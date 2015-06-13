package com.diogosantos.core;

import lombok.Builder;
import lombok.Getter;

import java.awt.image.BufferedImage;

@Getter
@Builder
public class Image {

    private BufferedImage buffered;

    private ImageMetadata imageMetadata;

    public String getFileType() {

        return "png";
    }

    public String getFilename() {
        return imageMetadata.getFilename();
    }

    public NamedSize getSize() {
        return imageMetadata.getSize();
    }
}



