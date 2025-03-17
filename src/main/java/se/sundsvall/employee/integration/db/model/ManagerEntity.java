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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "managers",
        indexes = {
                @Index(name = "managers_email_address_index", columnList = "email_address"),
                @Index(name = "managers_loginname_index", columnList = "loginname")
        })
public class ManagerEntity implements Serializable {

    private static final long serialVersionUID = -4581324515123451234L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

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

    public static ManagerEntity create() {
        return new ManagerEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public ManagerEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(final String givenname) {
        this.givenname = givenname;
    }

    public ManagerEntity withGivenname(final String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(final String middlename) {
        this.middlename = middlename;
    }

    public ManagerEntity withMiddlename(final String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public ManagerEntity withLastname(final String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(final String loginname) {
        this.loginname = loginname;
    }

    public ManagerEntity withLoginname(final String loginname) {
        this.loginname = loginname;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public ManagerEntity withEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public ManagerEntity withReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public ManagerEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public ManagerEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public ManagerEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public ManagerEntity withModifiedBy(final String modifiedBy) {
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
        return Objects.hash(id, givenname, middlename, lastname, loginname, emailAddress,
                referenceNumber, created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (ManagerEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(givenname, other.givenname) &&
                Objects.equals(middlename, other.middlename) &&
                Objects.equals(lastname, other.lastname) &&
                Objects.equals(loginname, other.loginname) &&
                Objects.equals(emailAddress, other.emailAddress) &&
                Objects.equals(referenceNumber, other.referenceNumber) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("ManagerEntity [id=").append(id)
                .append(", givenname=").append(givenname)
                .append(", middlename=").append(middlename)
                .append(", lastname=").append(lastname)
                .append(", loginname=").append(loginname)
                .append(", emailAddress=").append(emailAddress)
                .append(", referenceNumber=").append(referenceNumber)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}