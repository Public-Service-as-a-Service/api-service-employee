package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.time.OffsetDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Employee event model")
public class EmployeeEvent {

    @Schema(description = "Company ID", example = "1")
    private Integer companyId;

    @Schema(description = "Start date")
    private OffsetDateTime startDate;

    @Schema(description = "End date")
    private OffsetDateTime endDate;

    @Schema(description = "Title", example = "Software Developer")
    private String title;

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

    @Schema(description = "Event type", example = "HIRE")
    private String eventType;

    @Schema(description = "Event information")
    private String eventInfo;

    public static EmployeeEvent create() {
        return new EmployeeEvent();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public EmployeeEvent withCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public EmployeeEvent withStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public EmployeeEvent withEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmployeeEvent withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public EmployeeEvent withOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public EmployeeEvent withOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getTopOrgId() {
        return topOrgId;
    }

    public void setTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
    }

    public EmployeeEvent withTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
        return this;
    }

    public String getTopOrgName() {
        return topOrgName;
    }

    public void setTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
    }

    public EmployeeEvent withTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
        return this;
    }

    public Integer getBenefitGroupId() {
        return benefitGroupId;
    }

    public void setBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
    }

    public EmployeeEvent withBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EmployeeEvent withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public EmployeeEvent withEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, startDate, endDate, title, orgId, orgName, topOrgId,
                topOrgName, benefitGroupId, eventType, eventInfo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EmployeeEvent other = (EmployeeEvent) obj;
        return Objects.equals(companyId, other.companyId) &&
                Objects.equals(startDate, other.startDate) &&
                Objects.equals(endDate, other.endDate) &&
                Objects.equals(title, other.title) &&
                Objects.equals(orgId, other.orgId) &&
                Objects.equals(orgName, other.orgName) &&
                Objects.equals(topOrgId, other.topOrgId) &&
                Objects.equals(topOrgName, other.topOrgName) &&
                Objects.equals(benefitGroupId, other.benefitGroupId) &&
                Objects.equals(eventType, other.eventType) &&
                Objects.equals(eventInfo, other.eventInfo);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("EmployeeEvent [companyId=").append(companyId)
                .append(", startDate=").append(startDate)
                .append(", endDate=").append(endDate)
                .append(", title=").append(title)
                .append(", orgId=").append(orgId)
                .append(", orgName=").append(orgName)
                .append(", topOrgId=").append(topOrgId)
                .append(", topOrgName=").append(topOrgName)
                .append(", benefitGroupId=").append(benefitGroupId)
                .append(", eventType=").append(eventType)
                .append(", eventInfo=").append(eventInfo)
                .append("]").toString();
    }
}