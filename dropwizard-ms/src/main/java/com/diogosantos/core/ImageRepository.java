package com.diogosantos.core;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.diogosantos.core.data.S3Storage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class ImageRepository {

    private S3Storage storage = new S3Storage();

    private FileDirectoryStrategy directoryStrategy = new FileDirectoryStrategy();

    public void add(Image requested) {

    }

    public boolean contains(ImageRequest imageRequest) {
        String imagePath = directoryStrategy.getPath(imageRequest.getSize(), imageRequest.getFilename());
        return storage.contains(imagePath);
    }

    public Image getImage(ImageRequest imageRequest) throws IOException {
        String imagePath = directoryStrategy.getPath(imageRequest.getSize(), imageRequest.getFilename());
        return storage.getImage(imagePath);
    }


}
