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
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "portal_person_data",
        indexes = {
                @Index(name = "portal_person_data_employee_id_index", columnList = "employee_id"),
                @Index(name = "portal_person_data_email_index", columnList = "email"),
                @Index(name = "portal_person_data_is_manager_index", columnList = "is_manager")
        })
public class PortalPersonDataEntity implements Serializable {

    private static final long serialVersionUID = -3214312312341234123L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "employee_id", nullable = false)
    private String employeeId;

    @Column(name = "givenname")
    private String givenname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "address")
    private String address;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "work_phone")
    private String workPhone;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Column(name = "extra_mobile_phone")
    private String extraMobilePhone;

    @Column(name = "about_me")
    private String aboutMe;

    @Column(name = "email")
    private String email;

    @Column(name = "mail_nickname")
    private String mailNickname;

    @Column(name = "company")
    private String company;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "org_tree")
    private String orgTree;

    @Column(name = "reference_number")
    private String referenceNumber;

    @Column(name = "is_manager")
    private Boolean isManager;

    @Column(name = "loginname")
    private String loginname;

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

    public static PortalPersonDataEntity create() {
        return new PortalPersonDataEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public PortalPersonDataEntity withId(final String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public PortalPersonDataEntity withEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(final String givenname) {
        this.givenname = givenname;
    }

    public PortalPersonDataEntity withGivenname(final String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(final String lastname) {
        this.lastname = lastname;
    }

    public PortalPersonDataEntity withLastname(final String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }

    public PortalPersonDataEntity withFullname(final String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public PortalPersonDataEntity withAddress(final String address) {
        this.address = address;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    public PortalPersonDataEntity withPostalCode(final String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(final String city) {
        this.city = city;
    }

    public PortalPersonDataEntity withCity(final String city) {
        this.city = city;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(final String workPhone) {
        this.workPhone = workPhone;
    }

    public PortalPersonDataEntity withWorkPhone(final String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public PortalPersonDataEntity withMobilePhone(final String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getExtraMobilePhone() {
        return extraMobilePhone;
    }

    public void setExtraMobilePhone(final String extraMobilePhone) {
        this.extraMobilePhone = extraMobilePhone;
    }

    public PortalPersonDataEntity withExtraMobilePhone(final String extraMobilePhone) {
        this.extraMobilePhone = extraMobilePhone;
        return this;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(final String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public PortalPersonDataEntity withAboutMe(final String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public PortalPersonDataEntity withEmail(final String email) {
        this.email = email;
        return this;
    }

    public String getMailNickname() {
        return mailNickname;
    }

    public void setMailNickname(final String mailNickname) {
        this.mailNickname = mailNickname;
    }

    public PortalPersonDataEntity withMailNickname(final String mailNickname) {
        this.mailNickname = mailNickname;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(final String company) {
        this.company = company;
    }

    public PortalPersonDataEntity withCompany(final String company) {
        this.company = company;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(final Integer companyId) {
        this.companyId = companyId;
    }

    public PortalPersonDataEntity withCompanyId(final Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getOrgTree() {
        return orgTree;
    }

    public void setOrgTree(final String orgTree) {
        this.orgTree = orgTree;
    }

    public PortalPersonDataEntity withOrgTree(final String orgTree) {
        this.orgTree = orgTree;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PortalPersonDataEntity withReferenceNumber(final String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(final Boolean isManager) {
        this.isManager = isManager;
    }

    public PortalPersonDataEntity withIsManager(final Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(final String loginname) {
        this.loginname = loginname;
    }

    public PortalPersonDataEntity withLoginname(final String loginname) {
        this.loginname = loginname;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(final OffsetDateTime created) {
        this.created = created;
    }

    public PortalPersonDataEntity withCreated(final OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public PortalPersonDataEntity withCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(final OffsetDateTime modified) {
        this.modified = modified;
    }

    public PortalPersonDataEntity withModified(final OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public PortalPersonDataEntity withModifiedBy(final String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(final EmployeeEntity employee) {
        this.employee = employee;
    }

    public PortalPersonDataEntity withEmployee(final EmployeeEntity employee) {
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
        return Objects.hash(id, employeeId, givenname, lastname, fullname, address, postalCode, city, workPhone,
                mobilePhone, extraMobilePhone, aboutMe, email, mailNickname, company, companyId, orgTree,
                referenceNumber, isManager, loginname, created, createdBy, modified, modifiedBy);
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        final var other = (PortalPersonDataEntity) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(employeeId, other.employeeId) &&
                Objects.equals(givenname, other.givenname) &&
                Objects.equals(lastname, other.lastname) &&
                Objects.equals(fullname, other.fullname) &&
                Objects.equals(address, other.address) &&
                Objects.equals(postalCode, other.postalCode) &&
                Objects.equals(city, other.city) &&
                Objects.equals(workPhone, other.workPhone) &&
                Objects.equals(mobilePhone, other.mobilePhone) &&
                Objects.equals(extraMobilePhone, other.extraMobilePhone) &&
                Objects.equals(aboutMe, other.aboutMe) &&
                Objects.equals(email, other.email) &&
                Objects.equals(mailNickname, other.mailNickname) &&
                Objects.equals(company, other.company) &&
                Objects.equals(companyId, other.companyId) &&
                Objects.equals(orgTree, other.orgTree) &&
                Objects.equals(referenceNumber, other.referenceNumber) &&
                Objects.equals(isManager, other.isManager) &&
                Objects.equals(loginname, other.loginname) &&
                Objects.equals(created, other.created) &&
                Objects.equals(createdBy, other.createdBy) &&
                Objects.equals(modified, other.modified) &&
                Objects.equals(modifiedBy, other.modifiedBy);
    }

    @Override
    public String toString() {
        final var builder = new StringBuilder();
        builder.append("PortalPersonDataEntity [id=").append(id)
                .append(", employeeId=").append(employeeId)
                .append(", givenname=").append(givenname)
                .append(", lastname=").append(lastname)
                .append(", fullname=").append(fullname)
                .append(", address=").append(address)
                .append(", postalCode=").append(postalCode)
                .append(", city=").append(city)
                .append(", workPhone=").append(workPhone)
                .append(", mobilePhone=").append(mobilePhone)
                .append(", extraMobilePhone=").append(extraMobilePhone)
                .append(", aboutMe=").append(aboutMe)
                .append(", email=").append(email)
                .append(", mailNickname=").append(mailNickname)
                .append(", company=").append(company)
                .append(", companyId=").append(companyId)
                .append(", orgTree=").append(orgTree)
                .append(", referenceNumber=").append(referenceNumber)
                .append(", isManager=").append(isManager)
                .append(", loginname=").append(loginname)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]");
        return builder.toString();
    }
}