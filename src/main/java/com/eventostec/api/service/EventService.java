package com.eventostec.api.service;

import com.amazonaws.services.s3.AmazonS3;
import com.eventostec.api.domain.event.Event;
import com.eventostec.api.domain.event.EventRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Service
public class EventService {

    @Value("${aws.bucket.name}")
    private String awsBucket;

    @Autowired
    private AmazonS3 s3Client;

    public Event CreateEvent(EventRequestDTO data) {
        String imgUrl = null;

        if (data.image() != null)
        {
            imgUrl = uploadImg(data.image());
        }

        Event newEvent = new Event();

        newEvent.setTitle(data.title());
        newEvent.setDescription(data.description());
        newEvent.setEventurl(data.eventUrl());
        newEvent.setDate(new Date(data.date()));
        newEvent.setImgurl(imgUrl);

        return newEvent;
    }

    public String uploadImg(MultipartFile multipartFile) {

        String imgName = UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();

        try
        {
            File file = convertMultipartToFile(multipartFile);
            s3Client.putObject(awsBucket,imgName, file);

            file.delete();

            return s3Client.getUrl(awsBucket,imgName).toString();

        } catch (Exception e)
        {
            System.out.println("Erro ao subir o arquivo!");
            return null;
        }
    }

    private File convertMultipartToFile(MultipartFile multipartFile) throws IOException {

        File convFile = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);

        fos.write(multipartFile.getBytes());
        fos.close();

        return convFile;
    }
}
