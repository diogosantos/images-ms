package core.model;

import core.data.FileDirectoryStrategy;
import core.data.S3Storage;
import lombok.AllArgsConstructor;

import java.awt.image.BufferedImage;
import java.io.IOException;

@AllArgsConstructor
public class ImageRepository {

    private S3Storage storage;

    private FileDirectoryStrategy directoryStrategy;

    public void add(Image image) throws IOException {
        String imagePath = directoryStrategy.getPath(image.getSize(), image.getFilename());
        storage.add(image.getBuffered(), imagePath);
    }

    public boolean contains(ImageMetadata imageMetadata) {
        String imagePath = directoryStrategy.getPath(imageMetadata.getSize(), imageMetadata.getFilename());
        return storage.contains(imagePath);
    }

    public Image get(ImageMetadata imageMetadata) throws IOException {
        String imagePath = directoryStrategy.getPath(imageMetadata.getSize(), imageMetadata.getFilename());
        BufferedImage bufferedImage = storage.getImage(imagePath);

        return Image.builder()
                .buffered(bufferedImage)
                .imageMetadata(imageMetadata)
                .build();
    }


}
