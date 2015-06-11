package com.diogosantos.core;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by diogo on 11/06/15.
 */
public class ImageRepository {

    public Image getImage(String size, String filename) throws IOException {
        BufferedImage read = ImageIO.read(new URL("http://www.google.com.br/images/srpr/logo11w.png"));
        return Image.builder().buffered(read).build();
    }

    public boolean contains(String size, String filename) {
        return true;
    }

    public Image getOriginal(String filename) {
        return null;
    }

    public void add(Image requested) {

    }
}
