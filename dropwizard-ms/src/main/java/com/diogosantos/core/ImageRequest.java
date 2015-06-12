package com.diogosantos.core;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by diogo on 12/06/15.
 */
@Builder
@Getter
public class ImageRequest {

    private NamedSize size;

    private String filename;

    public String getFileType() {
        return "png";
    }
}
