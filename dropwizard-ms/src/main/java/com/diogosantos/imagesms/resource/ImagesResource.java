package com.diogosantos.imagesms.resource;

import com.diogosantos.core.Image;
import com.diogosantos.core.ImageMetadata;
import com.diogosantos.core.ImageService;
import com.diogosantos.core.NamedSize;
import lombok.AllArgsConstructor;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.OutputStream;

@Path("/image")
@AllArgsConstructor
public class ImagesResource {

    private ImageService imageService;

    @GET
    @Path("/show/{size}/{seo}")
    @Produces("image/png")
    public StreamingOutput getImage(@PathParam("size") String size,
                                    @PathParam("seo") String seo,
                                    @QueryParam("reference") String filename) throws IOException {

        final NamedSize namedSize = NamedSize.getValue(size);
        final ImageMetadata imageMetadata = ImageMetadata.builder().size(namedSize).filename(filename).build();
        final Image image = imageService.getImage(imageMetadata);

        return getStreamingOutput(image);
    }

    private StreamingOutput getStreamingOutput(final Image image) {
        return new StreamingOutput() {
            public void write(OutputStream output) throws IOException, WebApplicationException {
                ImageIO.write(image.getBuffered(), image.getFileType(), output);
            }
        };
    }

}