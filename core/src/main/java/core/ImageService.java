package core;

import core.model.Image;
import core.model.ImageMetadata;
import core.model.ImageRepository;
import core.model.NamedSize;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class ImageService {

    private ImageRepository repository;

    private ImageHandler handler;

    public Image getImage(ImageMetadata imageMetadata) throws IOException {

        if (repository.contains(imageMetadata)) {
            return repository.get(imageMetadata);
        }

        return getResizedImage(imageMetadata);
    }

    private Image getResizedImage(ImageMetadata imageMetadata) throws IOException {

        ImageMetadata originalImageMetadata = ImageMetadata.builder()
                .filename(imageMetadata.getFilename())
                .size(NamedSize.ORIGINAL)
                .build();
        Image original = repository.get(originalImageMetadata);

        Image requested = handler.resize(imageMetadata, original);

        repository.add(requested);

        return requested;
    }
}
