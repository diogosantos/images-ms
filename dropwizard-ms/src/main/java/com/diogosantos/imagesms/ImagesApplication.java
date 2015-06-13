package com.diogosantos.imagesms;

import com.diogosantos.imagesms.resource.ImagesResource;
import core.ImageHandler;
import core.ImageService;
import core.data.FileDirectoryStrategy;
import core.data.S3Storage;
import core.model.ImageRepository;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ImagesApplication extends Application<ImagesConfiguration> {

    public static void main(String args[]) throws Exception {
        new ImagesApplication().run("server", "dropwizard-ms/src/main/resources/config.yml");
    }

    @Override
    public void run(ImagesConfiguration configuration, Environment environment) throws Exception {
        final S3Storage storage = configuration.getS3StorageInstance();
        final ImageRepository imageRepository = new ImageRepository(storage, new FileDirectoryStrategy());
        final ImageService imageService = new ImageService(imageRepository, new ImageHandler());
        final ImagesResource imagesResource = new ImagesResource(imageService);

        environment.jersey().register(imagesResource);
    }

}
