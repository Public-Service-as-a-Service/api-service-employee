package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Manager model")
public class Manager {

    @Schema(description = "Person ID (UUID)", example = "b82bd8ac-1507-4d9a-958d-369261eecc15")
    private UUID personId;

    @Schema(description = "Given name", example = "Anders")
    private String givenname;

    @Schema(description = "Middle name", example = "Karl")
    private String middlename;

    @Schema(description = "Last name", example = "Andersson")
    private String lastname;

    @Schema(description = "Login name", example = "andand")
    private String loginname;

    @Schema(description = "Email address", example = "anders.andersson@example.com")
    private String emailAddress;

    @Schema(description = "Reference number", example = "12345")
    private String referenceNumber;

    public static Manager create() {
        return new Manager();
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public Manager withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public Manager withGivenname(String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Manager withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Manager withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Manager withLoginname(String loginname) {
        this.loginname = loginname;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Manager withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Manager withReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, givenname, middlename, lastname, loginname, emailAddress, referenceNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manager other = (Manager) obj;
        return Objects.equals(personId, other.personId) &&
                Objects.equals(givenname, other.givenname) &&
                Objects.equals(middlename, other.middlename) &&
                Objects.equals(lastname, other.lastname) &&
                Objects.equals(loginname, other.loginname) &&
                Objects.equals(emailAddress, other.emailAddress) &&
                Objects.equals(referenceNumber, other.referenceNumber);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Manager [personId=").append(personId)
                .append(", givenname=").append(givenname)
                .append(", middlename=").append(middlename)
                .append(", lastname=").append(lastname)
                .append(", loginname=").append(loginname)
                .append(", emailAddress=").append(emailAddress)
                .append(", referenceNumber=").append(referenceNumber)
                .append("]").toString();
    }
}