package com.diogosantos.core.data;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.diogosantos.core.Image;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

@Slf4j
public class S3Storage {

    private String bucketName = "images-ms-bucket";

    private AmazonS3Client s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());

    public BufferedImage getImage(String key) throws IOException {

        log.debug(String.format("requesting s3 for %s", key));
        S3Object objectPortion = s3Client.getObject(bucketName, key);
        InputStream objectData = objectPortion.getObjectContent();

        try {

            return ImageIO.read(objectData);
        } finally {
            if (objectData != null) {
                objectData.close();
            }
        }
    }

    public boolean contains(String key) {

        try {

            s3Client.getObjectMetadata(bucketName, key);
            return true;
        } catch (AmazonServiceException e) {
            if (e.getStatusCode() == 404) {
                return false;
            } else {
                throw e;
            }
        }
    }


    public void add(BufferedImage file, String key) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(file, "gif", os);
        s3Client.putObject(bucketName, key, new ByteArrayInputStream(os.toByteArray()), null);
    }
}
