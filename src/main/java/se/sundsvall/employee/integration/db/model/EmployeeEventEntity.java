package se.sundsvall.employee.integration.db.model;

import jakarta.persistence.*;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UuidGenerator;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity
@Table(name = "employee_event")
public class EmployeeEventEntity implements Serializable {

    private static final long serialVersionUID = 6789683682436857292L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "start_date")
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE)
    private OffsetDateTime startDate;

    @Column(name = "end_date")
    @TimeZoneStorage(TimeZoneStorageType.NORMALIZE)
    private OffsetDateTime endDate;

    @Column(name = "title")
    private String title;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "top_org_id")
    private Integer topOrgId;

    @Column(name = "top_org_name")
    private String topOrgName;

    @Column(name = "benefit_group_id")
    private Integer benefitGroupId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_info")
    private String eventInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    public static EmployeeEventEntity create() {
        return new EmployeeEventEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmployeeEventEntity withId(String id) {
        this.id = id;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public EmployeeEventEntity withCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public OffsetDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
    }

    public EmployeeEventEntity withStartDate(OffsetDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public OffsetDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
    }

    public EmployeeEventEntity withEndDate(OffsetDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmployeeEventEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public EmployeeEventEntity withOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public EmployeeEventEntity withOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getTopOrgId() {
        return topOrgId;
    }

    public void setTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
    }

    public EmployeeEventEntity withTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
        return this;
    }

    public String getTopOrgName() {
        return topOrgName;
    }

    public void setTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
    }

    public EmployeeEventEntity withTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
        return this;
    }

    public Integer getBenefitGroupId() {
        return benefitGroupId;
    }

    public void setBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
    }

    public EmployeeEventEntity withBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EmployeeEventEntity withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public EmployeeEventEntity withEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public EmployeeEventEntity withEmployee(EmployeeEntity employee) {
        this.employee = employee;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEventEntity that = (EmployeeEventEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(companyId, that.companyId) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(orgId, that.orgId) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(topOrgId, that.topOrgId) &&
                Objects.equals(topOrgName, that.topOrgName) &&
                Objects.equals(benefitGroupId, that.benefitGroupId) &&
                Objects.equals(eventType, that.eventType) &&
                Objects.equals(eventInfo, that.eventInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId, startDate, endDate, title, orgId, orgName,
                topOrgId, topOrgName, benefitGroupId, eventType, eventInfo);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("EmployeeEventEntity [id=").append(id)
                .append(", companyId=").append(companyId)
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