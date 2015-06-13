package core.model;

import lombok.Getter;

@Getter
public enum ScaleType {

    CROP(1),
    FILL(2),
    SKEW(3);

    private int code;

    ScaleType(int code) {
        this.code = code;
    }

}
