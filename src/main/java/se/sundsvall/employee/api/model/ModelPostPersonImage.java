package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Model for posting person image")
public class ModelPostPersonImage {

    @Schema(description = "Title of the image", example = "Profile Picture")
    private String title;

    @Schema(description = "Base64 encoded image data")
    private String imageData;

    public static ModelPostPersonImage create() {
        return new ModelPostPersonImage();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ModelPostPersonImage withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

    public ModelPostPersonImage withImageData(String imageData) {
        this.imageData = imageData;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, imageData);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ModelPostPersonImage other = (ModelPostPersonImage) obj;
        return Objects.equals(title, other.title) &&
                Objects.equals(imageData, other.imageData);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("ModelPostPersonImage [title=").append(title)
                .append(", imageData=").append(imageData)
                .append("]").toString();
    }
}