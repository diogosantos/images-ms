package com.diogosantos.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.imageio.ImageIO;
import javax.ws.rs.core.StreamingOutput;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by diogo on 11/06/15.
 */
@Getter
@Builder
public class Image {

    private BufferedImage buffered;

}



