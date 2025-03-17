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
@Table(name = "login_names",
        indexes = {
                @Index(name = "login_names_employee_id_index", columnList = "employee_id"),
                @Index(name = "login_names_domain_index", columnList = "domain"),
                @Index(name = "login_names_login_name_index", columnList = "login_name")
        })
public class LoginNameEntity implements Serializable {

    private static final long serialVersionUID = -1234512345123451234L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "domain")
    private String domain;

    @Column(name = "login_name")
    private String loginName;

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
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    public static LoginNameEntity create() {
        return new LoginNameEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public LoginNameEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public LoginNameEntity withEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(final String domain) {
        this.domain = domain;
    }

    public LoginNameEntity withDomain(final String domain) {
        this.domain = domain;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(final String loginName) {
        this.loginName = loginName;
    }

    public LoginNameEntity withLoginName(final String loginName) {
        this.loginName = loginName;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public LoginNameEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public LoginNameEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public LoginNameEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LoginNameEntity withModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeEntity employee) {
        this.employee = employee;
    }

    public LoginNameEntity withEmployee(final EmployeeEntity employee) {
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
        return Objects.hash(id, employeeId, domain, loginName, created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (LoginNameEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(employeeId, other.employeeId) &&
                Objects.equals(domain, other.domain) &&
                Objects.equals(loginName, other.loginName) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("LoginNamesEntity [id=").append(id)
                .append(", employeeId=").append(employeeId)
                .append(", domain=").append(domain)
                .append(", loginName=").append(loginName)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}
