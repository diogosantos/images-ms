package core.model;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by diogo on 12/06/15.
 */
@Builder
@Getter
public class ImageMetadata {

    private NamedSize size;

    private String filename;

    public String getFileType() {
        return filename.split("\\.")[1];
    }

    public int getHeight() {
        return size.getHeight();
    }

    public int getWidth() {
        return size.getWidth();
    }

    public ScaleType getSizingScale() {
        return size.getScale();
    }
}
