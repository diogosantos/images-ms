package com.diogosantos.imagesms.resource;

import com.diogosantos.core.Image;
import com.diogosantos.core.ImageService;
import lombok.AllArgsConstructor;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by diogo on 10/06/15.
 */
@Path("/image")
@AllArgsConstructor
public class ImagesResource {

    private ImageService imageService;

    @GET
    @Path("/{size}/{seo}/{filename}")
    @Produces("image/png")
    public StreamingOutput getImage(@PathParam("size") String size,
                                    @PathParam("seo") String seo,
                                    @PathParam("filename") String filename) throws IOException {

        final Image image = imageService.getImage(size, filename);

        return new StreamingOutput() {
            public void write(OutputStream output) throws IOException,
                    WebApplicationException {
                ImageIO.write(image.getBuffered(), "png", output);
            }
        };

    }

}