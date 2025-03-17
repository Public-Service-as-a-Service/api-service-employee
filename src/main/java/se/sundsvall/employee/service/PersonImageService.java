package se.sundsvall.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import se.sundsvall.employee.api.model.ModelPostPersonImage;
import se.sundsvall.employee.integration.db.PersonImageRepository;

import java.util.UUID;

import static org.zalando.problem.Status.NOT_FOUND;
import static se.sundsvall.employee.service.mapper.PersonImageMapper.toPersonImageEntity;

@Service
@Transactional
public class PersonImageService {

    private final PersonImageRepository personImageRepository;

    public PersonImageService(PersonImageRepository personImageRepository) {
        this.personImageRepository = personImageRepository;
    }

    public byte[] getPersonImage(UUID personId, Integer width) {
        var personImage = personImageRepository.findByEmployeeId(personId)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Person image for person id %s not found", personId)));

        if (width != null) {
            // TODO: Implement image resize logic if needed
            return personImage.getImageData();
        }
        return personImage.getImageData();
    }

    public void updatePersonImage(UUID personId, ModelPostPersonImage image) {
        var personImage = personImageRepository.findByEmployeeId(personId)
                .orElse(toPersonImageEntity(image)
                        .withEmployeeId(personId.toString()));

        personImage.setTitle(image.getTitle());
        personImage.setImageData(image.getImageData().getBytes());

        personImageRepository.save(personImage);
    }

    public void deletePersonImage(UUID personId) {
        if (!personImageRepository.existsByEmployeeId(personId)) {
            throw Problem.valueOf(NOT_FOUND,
                    String.format("Person image for person id %s not found", personId));
        }

        personImageRepository.deleteByEmployeeId(personId);
    }
}