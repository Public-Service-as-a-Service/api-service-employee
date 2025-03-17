package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Portal person data model")
public class PortalPersonData {

    @Schema(description = "Person ID (UUID)", example = "b82bd8ac-1507-4d9a-958d-369261eecc15")
    private UUID personid;

    @Schema(description = "Given name", example = "Anders")
    private String givenname;

    @Schema(description = "Last name", example = "Andersson")
    private String lastname;

    @Schema(description = "Full name", example = "Anders Andersson")
    private String fullname;

    @Schema(description = "Address", example = "Storgatan 1")
    private String address;

    @Schema(description = "Postal code", example = "12345")
    private String postalCode;

    @Schema(description = "City", example = "Stockholm")
    private String city;

    @Schema(description = "Work phone", example = "+46701234567")
    private String workPhone;

    @Schema(description = "Mobile phone", example = "+46701234567")
    private String mobilePhone;

    @Schema(description = "Extra mobile phone", example = "+46701234567")
    private String extraMobilePhone;

    @Schema(description = "About me")
    private String aboutMe;

    @Schema(description = "Email address", example = "anders.andersson@example.com")
    private String email;

    @Schema(description = "Mail nickname", example = "anders.andersson")
    private String mailNickname;

    @Schema(description = "Company name", example = "Company AB")
    private String company;

    @Schema(description = "Company ID", example = "1")
    private Integer companyId;

    @Schema(description = "Organization tree", example = "Department/Division")
    private String orgTree;

    @Schema(description = "Reference number", example = "ABC123")
    private String referenceNumber;

    @Schema(description = "Is manager", example = "true")
    private boolean isManager;

    @Schema(description = "Login name", example = "anders.andersson")
    private String loginName;

    public static PortalPersonData create() {
        return new PortalPersonData();
    }

    public UUID getPersonid() {
        return personid;
    }

    public void setPersonid(UUID personid) {
        this.personid = personid;
    }

    public PortalPersonData withPersonid(UUID personid) {
        this.personid = personid;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public PortalPersonData withGivenname(String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public PortalPersonData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public PortalPersonData withFullname(String fullname) {
        this.fullname = fullname;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PortalPersonData withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public PortalPersonData withPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PortalPersonData withCity(String city) {
        this.city = city;
        return this;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public PortalPersonData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public PortalPersonData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getExtraMobilePhone() {
        return extraMobilePhone;
    }

    public void setExtraMobilePhone(String extraMobilePhone) {
        this.extraMobilePhone = extraMobilePhone;
    }

    public PortalPersonData withExtraMobilePhone(String extraMobilePhone) {
        this.extraMobilePhone = extraMobilePhone;
        return this;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public PortalPersonData withAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PortalPersonData withEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMailNickname() {
        return mailNickname;
    }

    public void setMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
    }

    public PortalPersonData withMailNickname(String mailNickname) {
        this.mailNickname = mailNickname;
        return this;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public PortalPersonData withCompany(String company) {
        this.company = company;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public PortalPersonData withCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getOrgTree() {
        return orgTree;
    }

    public void setOrgTree(String orgTree) {
        this.orgTree = orgTree;
    }

    public PortalPersonData withOrgTree(String orgTree) {
        this.orgTree = orgTree;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public PortalPersonData withReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public boolean isManager() {
        return isManager;
    }

    public void setManager(boolean isManager) {
        this.isManager = isManager;
    }

    public PortalPersonData withManager(boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public PortalPersonData withLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personid, givenname, lastname, fullname, address, postalCode, city,
                workPhone, mobilePhone, extraMobilePhone, aboutMe, email, mailNickname, company,
                companyId, orgTree, referenceNumber, isManager, loginName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PortalPersonData other = (PortalPersonData) obj;
        return isManager == other.isManager &&
                Objects.equals(personid, other.personid) &&
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
                Objects.equals(loginName, other.loginName);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("PortalPersonData [personid=").append(personid)
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
                .append(", loginName=").append(loginName)
                .append("]").toString();
    }
}