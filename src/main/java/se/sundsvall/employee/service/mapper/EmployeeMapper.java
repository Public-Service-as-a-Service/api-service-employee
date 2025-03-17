package se.sundsvall.employee.service.mapper;

import se.sundsvall.employee.api.model.*;
import se.sundsvall.employee.integration.db.model.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class EmployeeMapper {

    private EmployeeMapper() {}

    public static Employee toEmployee(final EmployeeEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> Employee.create()
                        .withPersonId(UUID.fromString(e.getId()))
                        .withPersonNumber(e.getPersonNumber())
                        .withClassified(e.isClassified())
                        .withGivenname(e.getGivenname())
                        .withMiddlename(e.getMiddlename())
                        .withLastname(e.getLastname())
                        .withLoginname(e.getLoginname())
                        .withEmailAddress(e.getEmailAddress())
                        .withReferenceNumber(e.getReferenceNumber())
                        .withIsManager(e.isManager())
                        .withEmployments(toEmployments(e.getEmployments()))
                        .withEmployeeEvents(toEmployeeEvents(e.getEmployeeEvents())))
                .orElse(null);
    }

    public static List<Employee> toEmployees(final List<EmployeeEntity> employeeEntities) {
        return ofNullable(employeeEntities).orElse(emptyList()).stream()
                .map(EmployeeMapper::toEmployee)
                .filter(Objects::nonNull)
                .toList();
    }

    private static List<Employment> toEmployments(final List<EmploymentEntity> employmentEntities) {
        return ofNullable(employmentEntities).orElse(emptyList()).stream()
                .map(EmployeeMapper::toEmployment)
                .filter(Objects::nonNull)
                .toList();
    }

    private static Employment toEmployment(final EmploymentEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> Employment.create()
                        .withCompanyId(e.getCompanyId())
                        .withStartDate(e.getStartDate())
                        .withEndDate(e.getEndDate())
                        .withEmploymentType(e.getEmploymentType())
                        .withTitle(e.getTitle())
                        .withManagerCode(e.getManagerCode())
                        .withOrgId(e.getOrgId())
                        .withOrgName(e.getOrgName())
                        .withTopOrgId(e.getTopOrgId())
                        .withTopOrgName(e.getTopOrgName())
                        .withBenefitGroupId(e.getBenefitGroupId())
                        .withFormOfEmploymentId(e.getFormOfEmploymentId())
                        .withManual(e.isManual())
                        .withPaTeam(e.getPaTeam())
                        .withMainEmployment(e.isMainEmployment())
                        .withManager(toManager(e.getManager()))
                        .withAid(e.getAid())
                        .withEventType(e.getEventType())
                        .withEventInfo(e.getEventInfo())
                        .withEmpRowId(e.getEmpRowId()))
                .orElse(null);
    }

    private static List<EmployeeEvent> toEmployeeEvents(final List<EmployeeEventEntity> eventEntities) {
        return ofNullable(eventEntities).orElse(emptyList()).stream()
                .map(EmployeeMapper::toEmployeeEvent)
                .filter(Objects::nonNull)
                .toList();
    }

    private static EmployeeEvent toEmployeeEvent(final EmployeeEventEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> EmployeeEvent.create()
                        .withCompanyId(e.getCompanyId())
                        .withStartDate(e.getStartDate())
                        .withEndDate(e.getEndDate())
                        .withTitle(e.getTitle())
                        .withOrgId(e.getOrgId())
                        .withOrgName(e.getOrgName())
                        .withTopOrgId(e.getTopOrgId())
                        .withTopOrgName(e.getTopOrgName())
                        .withBenefitGroupId(e.getBenefitGroupId())
                        .withEventType(e.getEventType())
                        .withEventInfo(e.getEventInfo()))
                .orElse(null);
    }

    private static Manager toManager(final ManagerEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> Manager.create()
                        .withPersonId(UUID.fromString(e.getId()))
                        .withGivenname(e.getGivenname())
                        .withMiddlename(e.getMiddlename())
                        .withLastname(e.getLastname())
                        .withLoginname(e.getLoginname())
                        .withEmailAddress(e.getEmailAddress())
                        .withReferenceNumber(e.getReferenceNumber()))
                .orElse(null);
    }

    public static EmployeeEntity toEntity(final Employee employee) {
        return Optional.ofNullable(employee)
                .map(e -> EmployeeEntity.create()
                        .withId(e.getPersonId().toString())
                        .withPersonNumber(e.getPersonNumber())
                        .withClassified(e.isClassified())
                        .withGivenname(e.getGivenname())
                        .withMiddlename(e.getMiddlename())
                        .withLastname(e.getLastname())
                        .withLoginname(e.getLoginname())
                        .withEmailAddress(e.getEmailAddress())
                        .withReferenceNumber(e.getReferenceNumber())
                        .withManager(e.getIsManager()))
                .orElse(null);
    }
}