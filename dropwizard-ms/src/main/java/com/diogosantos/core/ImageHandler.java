package com.diogosantos.core;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageHandler {

    public Image resize(ImageMetadata imageMetadata, Image original) {

        BufferedImage bufferedImage = Scalr.resize(
                original.getBuffered(),
                Scalr.Method.SPEED,
                Scalr.Mode.FIT_EXACT,
                imageMetadata.getHeight(),
                imageMetadata.getWidth(),
                Scalr.OP_ANTIALIAS
        );

        return Image.builder().buffered(bufferedImage).imageMetadata(imageMetadata).build();
    }
}
