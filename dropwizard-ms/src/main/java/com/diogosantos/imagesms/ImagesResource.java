package com.diogosantos.imagesms;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by diogo on 10/06/15.
 */
@Path("/image")
public class ImagesResource {

    @GET
    @Path("/default")
    @Produces("image/png")
    public StreamingOutput getImage() throws IOException {

        final BufferedImage image = ImageIO.read(new URL("http://www.google.com.br/images/srpr/logo11w.png"));

        return new StreamingOutput() {
            public void write(OutputStream output) throws IOException,
                    WebApplicationException {
                ImageIO.write(image, "png", output);
            }
        };

    }

}