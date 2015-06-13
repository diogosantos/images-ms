package com.diogosantos.core;

import com.diogosantos.core.data.S3Storage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageRepository {

    private S3Storage storage = new S3Storage();

    private FileDirectoryStrategy directoryStrategy = new FileDirectoryStrategy();

    public void add(Image image) throws IOException {
        String imagePath = directoryStrategy.getPath(image.getSize(), image.getFilename());
        storage.add(image.getBuffered(), imagePath);
    }

    public boolean contains(ImageMetadata imageMetadata) {
        String imagePath = directoryStrategy.getPath(imageMetadata.getSize(), imageMetadata.getFilename());
        return storage.contains(imagePath);
    }

    public Image getImage(ImageMetadata imageMetadata) throws IOException {
        String imagePath = directoryStrategy.getPath(imageMetadata.getSize(), imageMetadata.getFilename());
        BufferedImage bufferedImage = storage.getImage(imagePath);

        return Image.builder()
                .buffered(bufferedImage)
                .imageMetadata(imageMetadata)
                .build();
    }


}
