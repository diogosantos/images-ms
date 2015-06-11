package com.diogosantos.imagesms.resource;

import com.diogosantos.core.Image;
import com.diogosantos.core.ImageTool;
import lombok.AllArgsConstructor;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
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
@AllArgsConstructor
public class ImagesResource {

    private ImageTool imageTool;

    @GET
    @Path("/{size}/{seo}/{filename}")
    @Produces("image/png")
    public StreamingOutput getImage(@PathParam("size") String size,
                                    @PathParam("seo") String seo,
                                    @PathParam("filename") String filename) throws IOException {

        final Image image = imageTool.getImage(size, filename);

        return new StreamingOutput() {
            public void write(OutputStream output) throws IOException,
                    WebApplicationException {
                ImageIO.write(image.getBuffered(), "png", output);
            }
        };

    }

}