package com.diogosantos.imagesms;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.fasterxml.jackson.annotation.JsonProperty;
import core.data.S3Storage;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ImagesConfiguration extends Configuration {

    @NotEmpty
    private String bucketName;

    private String accessKey;

    private String secretKey;

    @NotEmpty
    private String s3Authentication;

    @JsonProperty
    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    @JsonProperty
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @JsonProperty
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @JsonProperty
    public void setS3Authentication(String s3Authentication) {
        this.s3Authentication = s3Authentication;
    }

    public S3Storage getS3StorageInstance() {
        if ("chain".equalsIgnoreCase(s3Authentication)) {
            return new S3Storage(bucketName, new DefaultAWSCredentialsProviderChain());
        } else if ("basic".equalsIgnoreCase(s3Authentication)) {
            return new S3Storage(bucketName, accessKey, secretKey);
        }
        throw new IllegalArgumentException("Incorrect value for property 's3Authentication'. " +
                "Possible values are: 'chain' or 'basic.'");
    }
}
