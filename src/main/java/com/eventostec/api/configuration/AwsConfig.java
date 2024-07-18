package com.eventostec.api.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.eventostec.api.domain.aws.Params;
import com.eventostec.api.repositories.AWSParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    @Autowired
    private AWSParamsRepository awsRepository;

    @Bean
    public AmazonS3 createS3Instance() {

        Params param = awsRepository.findById(UUID.fromString("7629f957-de46-4e73-aace-5c2031c06df8")).orElse(null);

        AWSCredentials credentials = new BasicAWSCredentials(param.getAccesskeyid(), param.getSecretkey());

        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsRegion)
                .build();
    }
}
