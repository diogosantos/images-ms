package core.data;

import core.model.NamedSize;

public class FileDirectoryStrategy {

    public String getPath(NamedSize size, String filename) {
        return String.format("%s/%s", size.name().toLowerCase(), getProperDirectoryStructure(filename));
    }

    private String getProperDirectoryStructure(String filename) {
        String name = filename.split("\\.")[0];
        if (name.length() <= 4) {
            return filename;
        } else {
            return String.format("%s/%s", getFolderStructure(filename), filename);
        }
    }

    private String getFolderStructure(String filename) {
        String name = filename.split("\\.")[0];
        if (name.length() >= 8) {
            return String.format("%s/%s", name.substring(0, 4), name.substring(4, 8));
        } else {
            return name.substring(0, 4);
        }
    }
}
