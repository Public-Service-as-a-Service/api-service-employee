package se.sundsvall.employee.integration.db.model;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "manager_employees",
        indexes = {
                @Index(name = "manager_employees_manager_id_index", columnList = "manager_id"),
                @Index(name = "manager_employees_employee_id_index", columnList = "employee_id")
        })
public class ManagerEmployeeEntity implements Serializable {

    private static final long serialVersionUID = -5123412351234123412L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "manager_id", nullable = false)
    private String managerId;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

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

    @ManyToOne
    @JoinColumn(name = "manager_id", insertable = false, updatable = false)
    private ManagerEntity manager;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    public static ManagerEmployeeEntity create() {
        return new ManagerEmployeeEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ManagerEmployeeEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(final String managerId) {
        this.managerId = managerId;
    }

    public ManagerEmployeeEntity withManagerId(final String managerId) {
        this.managerId = managerId;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public ManagerEmployeeEntity withEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public ManagerEmployeeEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public ManagerEmployeeEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public ManagerEmployeeEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ManagerEmployeeEntity withModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(final ManagerEntity manager) {
        this.manager = manager;
    }

    public ManagerEmployeeEntity withManager(final ManagerEntity manager) {
        this.manager = manager;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeEntity employee) {
        this.employee = employee;
    }

    public ManagerEmployeeEntity withEmployee(final EmployeeEntity employee) {
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
        return Objects.hash(id, managerId, employeeId, created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (ManagerEmployeeEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(managerId, other.managerId) &&
                Objects.equals(employeeId, other.employeeId) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("ManagerEmployeesEntity [id=").append(id)
                .append(", managerId=").append(managerId)
                .append(", employeeId=").append(employeeId)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}
