package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.commons.lang3.StringUtils;

@JsonInclude(NON_NULL)
@Schema(description = "Employee model")
public class Employee {

    @Schema(description = "Person ID (UUID)", example = "b82bd8ac-1507-4d9a-958d-369261eecc15")
    private UUID personId;

    @Schema(description = "Person number", example = "1234567890")
    private String personNumber;

    @Schema(description = "Is classified", example = "true", required = true)
    private boolean isClassified;

    @Schema(description = "Given name", example = "Anders")
    private String givenname;

    @Schema(description = "Middle name", example = "Karl")
    private String middlename;

    @Schema(description = "Last name", example = "Andersson")
    private String lastname;

    @Schema(description = "Login name", example = "anders.andersson")
    private String loginname;

    @Schema(description = "Email address", example = "anders.andersson@example.com")
    private String emailAddress;

    @Schema(description = "Reference number", example = "ABC123")
    private String referenceNumber;

    @Schema(description = "Is manager", example = "false")
    private Boolean isManager;

    @Schema(description = "List of employments")
    private List<Employment> employments;

    @Schema(description = "List of employee events")
    private List<EmployeeEvent> employeeEvents;

    public static Employee create() {
        return new Employee();
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    public Employee withPersonId(UUID personId) {
        this.personId = personId;
        return this;
    }

    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    public Employee withPersonNumber(String personNumber) {
        this.personNumber = personNumber;
        return this;
    }

    public boolean isClassified() {
        return isClassified;
    }

    public void setClassified(boolean isClassified) {
        this.isClassified = isClassified;
    }

    public Employee withClassified(boolean isClassified) {
        this.isClassified = isClassified;
        return this;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public Employee withGivenname(String givenname) {
        this.givenname = givenname;
        return this;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Employee withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Employee withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public Employee withLoginname(String loginname) {
        this.loginname = loginname;
        return this;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Employee withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Employee withReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
        return this;
    }

    public Boolean getIsManager() {
        return isManager;
    }

    public void setIsManager(Boolean isManager) {
        this.isManager = isManager;
    }

    public Employee withIsManager(Boolean isManager) {
        this.isManager = isManager;
        return this;
    }

    public List<Employment> getEmployments() {
        return employments;
    }

    public void setEmployments(List<Employment> employments) {
        this.employments = employments;
    }

    public Employee withEmployments(List<Employment> employments) {
        this.employments = employments;
        return this;
    }

    public List<EmployeeEvent> getEmployeeEvents() {
        return employeeEvents;
    }

    public void setEmployeeEvents(List<EmployeeEvent> employeeEvents) {
        this.employeeEvents = employeeEvents;
    }

    public Employee withEmployeeEvents(List<EmployeeEvent> employeeEvents) {
        this.employeeEvents = employeeEvents;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, personNumber, isClassified, givenname, middlename, lastname,
                loginname, emailAddress, referenceNumber, isManager, employments, employeeEvents);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee other = (Employee) obj;
        return isClassified == other.isClassified &&
                Objects.equals(personId, other.personId) &&
                Objects.equals(personNumber, other.personNumber) &&
                Objects.equals(givenname, other.givenname) &&
                Objects.equals(middlename, other.middlename) &&
                Objects.equals(lastname, other.lastname) &&
                Objects.equals(loginname, other.loginname) &&
                Objects.equals(emailAddress, other.emailAddress) &&
                Objects.equals(referenceNumber, other.referenceNumber) &&
                Objects.equals(isManager, other.isManager) &&
                Objects.equals(employments, other.employments) &&
                Objects.equals(employeeEvents, other.employeeEvents);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Employee [personId=").append(personId)
                .append(", personNumber=").append(personNumber)
                .append(", isClassified=").append(isClassified)
                .append(", givenname=").append(givenname)
                .append(", middlename=").append(middlename)
                .append(", lastname=").append(lastname)
                .append(", loginname=").append(loginname)
                .append(", emailAddress=").append(emailAddress)
                .append(", referenceNumber=").append(referenceNumber)
                .append(", isManager=").append(isManager)
                .append(", employments=").append(employments != null ? StringUtils.join(employments, ", ") : null)
                .append(", employeeEvents=").append(employeeEvents != null ? StringUtils.join(employeeEvents, ", ") : null)
                .append("]").toString();
    }
}