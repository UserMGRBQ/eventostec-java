package com.eventostec.api.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String awsRegion;

    AWSCredentials credentials = new BasicAWSCredentials("AKIA6GBMBWALK3TS2HS6", "2r3NB1TgkVXCTXEyCuAjxX2/tFlSgK0DWDVgMj4L");

    @Bean
    public AmazonS3 createS3Instance() {
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(awsRegion)
                .build();
    }
}
