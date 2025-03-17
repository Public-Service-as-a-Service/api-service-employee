package se.sundsvall.employee.integration.db.model;

import static java.time.OffsetDateTime.now;
import static java.time.temporal.ChronoUnit.MILLIS;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Objects;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "employments",
        indexes = {
                @Index(name = "employments_employee_id_index", columnList = "employee_id"),
                @Index(name = "employments_company_id_index", columnList = "company_id"),
                @Index(name = "employments_title_index", columnList = "title")
        })
public class EmploymentEntity implements Serializable {

    private static final long serialVersionUID = 4789683682436857292L;

    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id;

    @Column(name = "employee_id")
    private String employeeId;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "employment_type")
    private Integer employmentType;

    @Column(name = "title")
    private String title;

    @Column(name = "manager_code")
    private String managerCode;

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

    @Column(name = "form_of_employment_id")
    private String formOfEmploymentId;

    @Column(name = "is_manual")
    private boolean isManual;

    @Column(name = "pa_team")
    private String paTeam;

    @Column(name = "is_main_employment")
    private boolean isMainEmployment;

    @Column(name = "aid")
    private String aid;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_info")
    private String eventInfo;

    @Column(name = "emp_row_id")
    private String empRowId;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private EmployeeEntity employee;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private ManagerEntity manager;

    public static EmploymentEntity create() {
        return new EmploymentEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EmploymentEntity withId(String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public EmploymentEntity withEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public EmploymentEntity withCompanyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public EmploymentEntity withStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public EmploymentEntity withEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public Integer getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
    }

    public EmploymentEntity withEmploymentType(Integer employmentType) {
        this.employmentType = employmentType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmploymentEntity withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(String managerCode) {
        this.managerCode = managerCode;
    }

    public EmploymentEntity withManagerCode(String managerCode) {
        this.managerCode = managerCode;
        return this;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public EmploymentEntity withOrgId(Integer orgId) {
        this.orgId = orgId;
        return this;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public EmploymentEntity withOrgName(String orgName) {
        this.orgName = orgName;
        return this;
    }

    public Integer getTopOrgId() {
        return topOrgId;
    }

    public void setTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
    }

    public EmploymentEntity withTopOrgId(Integer topOrgId) {
        this.topOrgId = topOrgId;
        return this;
    }

    public String getTopOrgName() {
        return topOrgName;
    }

    public void setTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
    }

    public EmploymentEntity withTopOrgName(String topOrgName) {
        this.topOrgName = topOrgName;
        return this;
    }

    public Integer getBenefitGroupId() {
        return benefitGroupId;
    }

    public void setBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
    }

    public EmploymentEntity withBenefitGroupId(Integer benefitGroupId) {
        this.benefitGroupId = benefitGroupId;
        return this;
    }

    public String getFormOfEmploymentId() {
        return formOfEmploymentId;
    }

    public void setFormOfEmploymentId(String formOfEmploymentId) {
        this.formOfEmploymentId = formOfEmploymentId;
    }

    public EmploymentEntity withFormOfEmploymentId(String formOfEmploymentId) {
        this.formOfEmploymentId = formOfEmploymentId;
        return this;
    }

    public boolean isManual() {
        return isManual;
    }

    public void setManual(boolean isManual) {
        this.isManual = isManual;
    }

    public EmploymentEntity withManual(boolean isManual) {
        this.isManual = isManual;
        return this;
    }

    public String getPaTeam() {
        return paTeam;
    }

    public void setPaTeam(String paTeam) {
        this.paTeam = paTeam;
    }

    public EmploymentEntity withPaTeam(String paTeam) {
        this.paTeam = paTeam;
        return this;
    }

    public boolean isMainEmployment() {
        return isMainEmployment;
    }

    public void setMainEmployment(boolean isMainEmployment) {
        this.isMainEmployment = isMainEmployment;
    }

    public EmploymentEntity withMainEmployment(boolean isMainEmployment) {
        this.isMainEmployment = isMainEmployment;
        return this;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public EmploymentEntity withAid(String aid) {
        this.aid = aid;
        return this;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public EmploymentEntity withEventType(String eventType) {
        this.eventType = eventType;
        return this;
    }

    public String getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
    }

    public EmploymentEntity withEventInfo(String eventInfo) {
        this.eventInfo = eventInfo;
        return this;
    }

    public String getEmpRowId() {
        return empRowId;
    }

    public void setEmpRowId(String empRowId) {
        this.empRowId = empRowId;
    }

    public EmploymentEntity withEmpRowId(String empRowId) {
        this.empRowId = empRowId;
        return this;
    }

    public OffsetDateTime getCreated() {
        return created;
    }

    public void setCreated(OffsetDateTime created) {
        this.created = created;
    }

    public EmploymentEntity withCreated(OffsetDateTime created) {
        this.created = created;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public EmploymentEntity withCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public OffsetDateTime getModified() {
        return modified;
    }

    public void setModified(OffsetDateTime modified) {
        this.modified = modified;
    }

    public EmploymentEntity withModified(OffsetDateTime modified) {
        this.modified = modified;
        return this;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public EmploymentEntity withModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public EmploymentEntity withEmployee(EmployeeEntity employee) {
        this.employee = employee;
        return this;
    }

    public ManagerEntity getManager() {
        return manager;
    }

    public void setManager(ManagerEntity manager) {
        this.manager = manager;
    }

    public EmploymentEntity withManager(ManagerEntity manager) {
        this.manager = manager;
        return this;
    }

    @PrePersist
    void prePersist() {
        created = now(ZoneId.systemDefault()).truncatedTo(MILLIS);
        createdBy = "TennyOne";
    }

    @PreUpdate
    void preUpdate() {
        modified = now(ZoneId.systemDefault()).truncatedTo(MILLIS);
        modifiedBy = "TennyOne";
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
        EmploymentEntity other = (EmploymentEntity) obj;
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
                .append("EmploymentEntity [id=").append(id)
                .append(", employeeId=").append(employeeId)
                .append(", companyId=").append(companyId)
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
                .append(", aid=").append(aid)
                .append(", eventType=").append(eventType)
                .append(", eventInfo=").append(eventInfo)
                .append(", empRowId=").append(empRowId)
                .append(", created=").append(created)
                .append(", createdBy=").append(createdBy)
                .append(", modified=").append(modified)
                .append(", modifiedBy=").append(modifiedBy)
                .append("]").toString();
    }
}