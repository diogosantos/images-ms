package core.model;

import lombok.Getter;

@Getter
public enum NamedSize {

    THUMBNAIL(150, 150, 80, ScaleType.CROP, null, ImageType.PNG),
    ORIGINAL(0, 0, 0, ScaleType.CROP, null, ImageType.JPG);

    private int height;
    private int width;
    private int quality;
    private ScaleType scale;
    private String color;
    private ImageType type;

    NamedSize(int height, int width, int quality, ScaleType scale, String color, ImageType imageType) {
        this.height = height;
        this.width = width;
        this.quality = quality;
        this.scale = scale;
        this.color = color;
        this.type = imageType;
    }

    public static NamedSize getValue(String value) {
        for (NamedSize size : values()) {
            if (size.name().equalsIgnoreCase(value)) {
                return size;
            }
        }
        throw new IllegalArgumentException(String.format("Couldn't find a size named '%s'.", value));
    }

}
