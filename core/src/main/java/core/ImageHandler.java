package core;

import core.model.Image;
import core.model.ImageMetadata;
import core.model.ScaleType;
import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageHandler {

    public Image resize(ImageMetadata imageMetadata, Image original) {

        BufferedImage bufferedImage = Scalr.resize(
                original.getBuffered(),
                Scalr.Method.SPEED,
                getSizingStrategy(imageMetadata.getSizingScale()),
                imageMetadata.getHeight(),
                imageMetadata.getWidth(),
                Scalr.OP_ANTIALIAS
        );

        return Image.builder().buffered(bufferedImage).imageMetadata(imageMetadata).build();
    }

    private Scalr.Mode getSizingStrategy(ScaleType scale) {
        switch (scale.getCode()) {
            case 1:
                return Scalr.Mode.FIT_EXACT;
            case 2:
                return Scalr.Mode.FIT_TO_HEIGHT;
            case 3:
                return Scalr.Mode.FIT_TO_WIDTH;
            default:
                return Scalr.Mode.AUTOMATIC;
        }
    }
}
