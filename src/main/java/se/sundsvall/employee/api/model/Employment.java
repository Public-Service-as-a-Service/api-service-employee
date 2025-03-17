package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Employment model")
public class Employment {

    @Schema(description = "Company ID", example = "1")
    private Integer companyId;

    @Schema(description = "Start date")
    private LocalDateTime startDate;

    @Schema(description = "End date")
    private LocalDateTime endDate;

    @Schema(description = "Employment type", example = "1")
    private Integer employmentType;

    @Schema(description = "Title", example = "Software Developer")
    private String title;

    @Schema(description = "Manager code", example = "MC123")
    private String managerCode;

    @Schema(description = "Organization ID", example = "1")
    private Integer orgId;

    @Schema(description = "Organization name", example = "IT Department")
    private String orgName;

    @Schema(description = "Top organization ID", example = "1")
    private Integer topOrgId;

    @Schema(description = "Top organization name", example = "Company Division")
    private String topOrgName;

    @Schema(description = "Benefit group ID")
    private Integer benefitGroupId;

    @Schema(description = "Form of employment ID", example = "FOE123")
    private String formOfEmploymentId;

    @Schema(description = "Is manual", example = "false")
    private boolean isManual;

    @Schema(description = "PA Team", example = "Team A")
    private String paTeam;

    @Schema(description = "Is main employment", example = "true")
    private boolean isMainEmployment;

    @Schema(description = "Manager information")
    private Manager manager;

    @Schema(description = "AID", example = "AID123")
    private String aid;

    @Schema(description = "Event type", example = "HIRE")
    private String eventType;

    @Schema(description = "Event information")
    private String eventInfo;

    @Schema(description = "Employment row ID", example = "EMP123")
    private String empRowId;

    public static Employment create() {
        return new Employment();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Employment withCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public Employment withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Employment withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
    }

    public Employment withEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employment withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public Employment withManagerCode(String managerCode) {
        this.managerCode = managerCode;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Employment withOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Employment withOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getTopOrgId() {
        return topOrgId;
    }

    public void setTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
    }

    public Employment withTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
        return this;
    }

    public String getTopOrgName() {
        return topOrgName;
    }

    public void setTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
    }

    public Employment withTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
        return this;
    }

    public Integer getBenefitGroupId() {
        return benefitGroupId;
    }

    public void setBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
    }

    public Employment withBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
        return this;
    }

    public String getFormOfEmploymentId() {
        return formOfEmploymentId;
    }

    public void setFormOfEmploymentId(String formOfEmploymentId) {
        this.formOfEmploymentId = formOfEmploymentId;
    }

    public Employment withFormOfEmploymentId(String formOfEmploymentId) {
        this.formOfEmploymentId = formOfEmploymentId;
        return this;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean isManual) {
        this.isManual = isManual;
    }

    public Employment withManual(boolean isManual) {
        this.isManual = isManual;
        return this;
    }

    public String getPaTeam() {
        return paTeam;
    }

    public void setPaTeam(String paTeam) {
        this.paTeam = paTeam;
    }

    public Employment withPaTeam(String paTeam) {
        this.paTeam = paTeam;
        return this;
    }

    public boolean isMainEmployment() {
        return isMainEmployment;
    }

    public void setMainEmployment(boolean isMainEmployment) {
        this.isMainEmployment = isMainEmployment;
    }

    public Employment withMainEmployment(boolean isMainEmployment) {
        this.isMainEmployment = isMainEmployment;
        return this;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public Employment withManager(Manager manager) {
        this.manager = manager;
        return this;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public Employment withAid(String aid) {
        this.aid = aid;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Employment withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public Employment withEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    public String getEmpRowId() {
        return empRowId;
    }

    public void setEmpRowId(String empRowId) {
        this.empRowId = empRowId;
    }

    public Employment withEmpRowId(String empRowId) {
        this.empRowId = empRowId;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, startDate, endDate, employmentType, title, managerCode,
                orgId, orgName, topOrgId, topOrgName, benefitGroupId, formOfEmploymentId, isManual,
                paTeam, isMainEmployment, manager, aid, eventType, eventInfo, empRowId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employment other = (Employment) obj;
        return isManual == other.isManual &&
                isMainEmployment == other.isMainEmployment &&
                Objects.equals(companyId, other.companyId) &&
                Objects.equals(startDate, other.startDate) &&
                Objects.equals(endDate, other.endDate) &&
                Objects.equals(employmentType, other.employmentType) &&
                Objects.equals(title, other.title) &&
                Objects.equals(managerCode, other.managerCode) &&
                Objects.equals(orgId, other.orgId) &&
                Objects.equals(orgName, other.orgName) &&
                Objects.equals(topOrgId, other.topOrgId) &&
                Objects.equals(topOrgName, other.topOrgName) &&
                Objects.equals(benefitGroupId, other.benefitGroupId) &&
                Objects.equals(formOfEmploymentId, other.formOfEmploymentId) &&
                Objects.equals(paTeam, other.paTeam) &&
                Objects.equals(manager, other.manager) &&
                Objects.equals(aid, other.aid) &&
                Objects.equals(eventType, other.eventType) &&
                Objects.equals(eventInfo, other.eventInfo) &&
                Objects.equals(empRowId, other.empRowId);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Employment [companyId=").append(companyId)
                .append(", startDate=").append(startDate)
                .append(", endDate=").append(endDate)
                .append(", employmentType=").append(employmentType)
                .append(", title=").append(title)
                .append(", managerCode=").append(managerCode)
                .append(", orgId=").append(orgId)
                .append(", orgName=").append(orgName)
                .append(", topOrgId=").append(topOrgId)
                .append(", topOrgName=").append(topOrgName)
                .append(", benefitGroupId=").append(benefitGroupId)
                .append(", formOfEmploymentId=").append(formOfEmploymentId)
                .append(", isManual=").append(isManual)
                .append(", paTeam=").append(paTeam)
                .append(", isMainEmployment=").append(isMainEmployment)
                .append(", manager=").append(manager)
                .append(", aid=").append(aid)
                .append(", eventType=").append(eventType)
                .append(", eventInfo=").append(eventInfo)
                .append(", empRowId=").append(empRowId)
                .append("]").toString();
    }
}