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
public class ImageTool {

    private ImageRepository repository;

    private ImageHandler handler;

    public Image getImage(String size, String filename) throws IOException {

        if(repository.contains(size, filename)) {
            return repository.getImage(size, filename);
        }

        Image original = repository.getOriginal(filename);
        Image requested = handler.resize(size, original);
        repository.add(requested);

        return requested;
    }

}
