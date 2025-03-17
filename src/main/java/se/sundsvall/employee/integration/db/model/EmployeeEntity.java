package se.sundsvall.employee.integration.db.model;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees",
        indexes = {
                @Index(name = "employees_person_number_index", columnList = "person_number"),
                @Index(name = "employees_email_address_index", columnList = "email_address"),
                @Index(name = "employees_is_manager_index", columnList = "is_manager"),
                @Index(name = "employees_loginname_index", columnList = "loginname")
        })
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = -3451441096651461590L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "person_number")
    private String personNumber;

    @Column(name = "is_classified")
    private Boolean isClassified;

    @Column(name = "givenname")
    private String givenname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "loginname")
    private String loginname;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "is_manager")
    private Boolean isManager;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmploymentEntity> employments = new ArrayList<>();

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeEventEntity> employeeEvents = new ArrayList<>();

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

    public static EmployeeEntity create() {
        return new EmployeeEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public EmployeeEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(final String personNumber) {
        this.personNumber = personNumber;
    }

    public EmployeeEntity withPersonNumber(final String personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    public Boolean isClassified() {
        return isClassified;
    }

    public void setClassified(final Boolean isClassified) {
        this.isClassified = isClassified;
    }

    public EmployeeEntity withClassified(final Boolean isClassified) {
        this.isClassified = isClassified;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(final String givenname) {
        this.givenname = givenname;
    }

    public EmployeeEntity withGivenname(final String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(final String middlename) {
        this.middlename = middlename;
    }

    public EmployeeEntity withMiddlename(final String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public EmployeeEntity withLastname(final String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(final String loginname) {
        this.loginname = loginname;
    }

    public EmployeeEntity withLoginname(final String loginname) {
        this.loginname = loginname;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public EmployeeEntity withEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public EmployeeEntity withReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public Boolean isManager() {
        return isManager;
    }

    public void setManager(final Boolean isManager) {
        this.isManager = isManager;
    }

    public EmployeeEntity withManager(final Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public List<EmploymentEntity> getEmployments() {
        return employments;
    }

    public void setEmployments(final List<EmploymentEntity> employments) {
        this.employments = employments;
    }

    public EmployeeEntity withEmployments(final List<EmploymentEntity> employments) {
        this.employments = employments;
        return this;
    }

    public List<EmployeeEventEntity> getEmployeeEvents() {
        return employeeEvents;
    }

    public void setEmployeeEvents(final List<EmployeeEventEntity> employeeEvents) {
        this.employeeEvents = employeeEvents;
    }

    public EmployeeEntity withEmployeeEvents(final List<EmployeeEventEntity> employeeEvents) {
        this.employeeEvents = employeeEvents;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public EmployeeEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public EmployeeEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public EmployeeEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public EmployeeEntity withModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
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
        return Objects.hash(id, personNumber, isClassified, givenname, middlename, lastname,
                loginname, emailAddress, referenceNumber, isManager, employments, employeeEvents,
                created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (EmployeeEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(personNumber, other.personNumber) &&
                Objects.equals(isClassified, other.isClassified) &&
                Objects.equals(givenname, other.givenname) &&
                Objects.equals(middlename, other.middlename) &&
                Objects.equals(lastname, other.lastname) &&
                Objects.equals(loginname, other.loginname) &&
                Objects.equals(emailAddress, other.emailAddress) &&
                Objects.equals(referenceNumber, other.referenceNumber) &&
                Objects.equals(isManager, other.isManager) &&
                Objects.equals(employments, other.employments) &&
                Objects.equals(employeeEvents, other.employeeEvents) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("EmployeeEntity [id=").append(id)
                .append(", personNumber=").append(personNumber)
                .append(", isClassified=").append(isClassified)
                .append(", givenname=").append(givenname)
                .append(", middlename=").append(middlename)
                .append(", lastname=").append(lastname)
                .append(", loginname=").append(loginname)
                .append(", emailAddress=").append(emailAddress)
                .append(", referenceNumber=").append(referenceNumber)
                .append(", isManager=").append(isManager)
                .append(", employments=").append(employments)
                .append(", employeeEvents=").append(employeeEvents)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}