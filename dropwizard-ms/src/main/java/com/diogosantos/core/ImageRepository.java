package com.diogosantos.core;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by diogo on 11/06/15.
 */
public class ImageRepository {

    private String bucketName = "images-ms-bucket";

    private AmazonS3Client s3Client = new AmazonS3Client(new DefaultAWSCredentialsProviderChain());

    public Image getImage(String size, String filename) throws IOException {
        try {
            S3Object objectPortion = s3Client.getObject(bucketName, filename);
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
    
    public boolean contains(String size, String filename) {
        try {
            s3Client.getObjectMetadata(bucketName, filename);
            return true;
        } catch (AmazonServiceException e) {
            if(e.getStatusCode() == 404) {
                return false;
            } else {
                throw e;
            }
        }
    }

    public Image getOriginal(String filename) throws IOException {
        if(contains("", filename)) {
            return getImage("", filename);
        }
        //TODO: 404
        throw new RuntimeException("original picture not found ");
    }

    public void add(Image requested) {

    }
}
