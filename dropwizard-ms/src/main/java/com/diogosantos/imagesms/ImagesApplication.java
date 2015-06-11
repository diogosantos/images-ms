package com.diogosantos.imagesms;

import com.diogosantos.core.ImageHandler;
import com.diogosantos.core.ImageRepository;
import com.diogosantos.core.ImageTool;
import com.diogosantos.imagesms.resource.ImagesResource;
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
        ImageTool imageTool = new ImageTool(new ImageRepository(), new ImageHandler());
        ImagesResource imagesResource = new ImagesResource(imageTool);

        environment.jersey().register(imagesResource);
    }

}
