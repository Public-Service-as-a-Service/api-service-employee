package se.sundsvall.employee.service.mapper;

import se.sundsvall.employee.api.model.ModelPostPersonImage;
import se.sundsvall.employee.integration.db.model.PersonImageEntity;

import java.util.Optional;
import java.util.Base64;

import static java.util.Optional.ofNullable;

public class PersonImageMapper {

    private PersonImageMapper() {}

    public static PersonImageEntity toPersonImageEntity(final ModelPostPersonImage model) {
        return Optional.ofNullable(model)
                .map(m -> PersonImageEntity.create()
                        .withTitle(m.getTitle())
                        .withImageData(Base64.getDecoder().decode(m.getImageData())))
                .orElse(null);
    }

    public static ModelPostPersonImage toModelPostPersonImage(final PersonImageEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> ModelPostPersonImage.create()
                        .withTitle(e.getTitle())
                        .withImageData(Base64.getEncoder().encodeToString(e.getImageData())))
                .orElse(null);
    }
}