package com.diogosantos.core;

import lombok.AllArgsConstructor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by diogo on 11/06/15.
 */
@AllArgsConstructor
public class ImageService {

    private ImageRepository repository;

    private ImageHandler handler;

    public Image getImage(ImageRequest imageRequest) throws IOException {

        if (repository.contains(imageRequest)) {
            return repository.getImage(imageRequest);
        }

        return getResizedImage(imageRequest);
    }

    private Image getResizedImage(ImageRequest imageRequest) throws IOException {

        ImageRequest originalImageRequest = ImageRequest.builder()
                .filename(imageRequest.getFilename())
                .size(NamedSize.ORIGINAL)
                .build();
        Image original = repository.getImage(originalImageRequest);

        Image requested = handler.resize(imageRequest.getSize(), original);

        repository.add(requested);

        return requested;
    }
}
