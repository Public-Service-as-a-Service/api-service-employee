package se.sundsvall.employee.integration.db.model;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Objects;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_images",
        indexes = {
                @Index(name = "person_images_employee_id_index", columnList = "employee_id")
        })
public class PersonImageEntity implements Serializable {

    private static final long serialVersionUID = -5123451234512341234L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "title")
    private String title;

    @Column(name = "image_data", columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @Column(name = "created")
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE)
    private OffsetDateTime created;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified")
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE)
    private OffsetDateTime modified;

    @Column(name = "modified_by")
    private String modifiedBy;

    @OneToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    public static PersonImageEntity create() {
        return new PersonImageEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public PersonImageEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public PersonImageEntity withEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public PersonImageEntity withTitle(final String title) {
        this.title = title;
        return this;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(final byte[] imageData) {
        this.imageData = imageData;
    }

    public PersonImageEntity withImageData(final byte[] imageData) {
        this.imageData = imageData;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public PersonImageEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public PersonImageEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public PersonImageEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public PersonImageEntity withModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeEntity employee) {
        this.employee = employee;
    }

    public PersonImageEntity withEmployee(final EmployeeEntity employee) {
        this.employee = employee;
        return this;
    }

    @PrePersist
    void prePersist() {
        created = now(ZoneId.systemDefault()).truncatedTo(MILLIS);
    }

    @PreUpdate
    void preUpdate() {
        modified = now(ZoneId.systemDefault()).truncatedTo(MILLIS);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, title, imageData, created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (PersonImageEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(employeeId, other.employeeId) &&
                Objects.equals(title, other.title) &&
                Arrays.equals(imageData, other.imageData) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("PersonImagesEntity [id=").append(id)
                .append(", employeeId=").append(employeeId)
                .append(", title=").append(title)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}
