package com.diogosantos.imagesms;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

/**
 * Created by diogo on 10/06/15.
 */
public class ImagesApplication extends Application<ImagesConfiguration> {


    public static void main(String args[]) throws Exception {
        new ImagesApplication().run("server", "dropwizard-ms/src/main/resources/config.yml");
    }

    @Override
    public void run(ImagesConfiguration imagesConfiguration, Environment environment) throws Exception {

        ImagesResource imagesResource = new ImagesResource();

        environment.jersey().register(imagesResource);

    }

}
