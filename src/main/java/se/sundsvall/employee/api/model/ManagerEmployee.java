package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Manager employee model")
public class ManagerEmployee {

    @Schema(description = "Person ID (UUID)", example = "b82bd8ac-1507-4d9a-958d-369261eecc15")
    private UUID personId;

    @Schema(description = "Hire date")
    private LocalDateTime hireDate;

    @Schema(description = "Retire date")
    private LocalDateTime retireDate;

    public static ManagerEmployee create() {
        return new ManagerEmployee();
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public ManagerEmployee withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public ManagerEmployee withHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public LocalDateTime getRetireDate() {
        return retireDate;
    }

    public void setRetireDate(LocalDateTime retireDate) {
        this.retireDate = retireDate;
    }

    public ManagerEmployee withRetireDate(LocalDateTime retireDate) {
        this.retireDate = retireDate;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, hireDate, retireDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ManagerEmployee other = (ManagerEmployee) obj;
        return Objects.equals(personId, other.personId) &&
                Objects.equals(hireDate, other.hireDate) &&
                Objects.equals(retireDate, other.retireDate);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("ManagerEmployee [personId=").append(personId)
                .append(", hireDate=").append(hireDate)
                .append(", retireDate=").append(retireDate)
                .append("]").toString();
    }
}