package com.diogosantos.core.data;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.S3Object;
import com.diogosantos.core.Image;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class S3Storage {

    private String bucketName = "images-ms-bucket";

    private AmazonS3Client s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());

    public Image getImage(String key) throws IOException {
        log.debug(String.format("requesting s3 for key %s", key));
        try {
            S3Object objectPortion = s3Client.getObject(bucketName, key);
            InputStream objectData = objectPortion.getObjectContent();

            try {
                BufferedImage read = ImageIO.read(objectData);
                return Image.builder().buffered(read).build();
            } finally {
                if(objectData != null) {
                    objectData.close();
                }
            }

        } catch (AmazonServiceException e) {
            throw e;
        } catch (AmazonClientException e) {
            throw e;
        }
    }

    public boolean contains(String key) {
        try {
            s3Client.getObjectMetadata(bucketName, key);
            return true;
        } catch (AmazonServiceException e) {
            if(e.getStatusCode() == 404) {
                return false;
            } else {
                throw e;
            }
        }
    }


}
