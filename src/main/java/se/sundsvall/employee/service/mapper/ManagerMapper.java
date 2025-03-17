package se.sundsvall.employee.service.mapper;

import se.sundsvall.employee.api.model.Manager;
import se.sundsvall.employee.api.model.ManagerEmployee;
import se.sundsvall.employee.integration.db.model.ManagerEntity;
import se.sundsvall.employee.integration.db.model.ManagerEmployeeEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class ManagerMapper {

    private ManagerMapper() {}

    public static Manager toManager(final ManagerEntity entity) {
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

    public static ManagerEmployee toManagerEmployee(final ManagerEmployeeEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> ManagerEmployee.create()
                        .withPersonId(UUID.fromString(e.getEmployeeId())))
                .orElse(null);
    }

    public static List<ManagerEmployee> toManagerEmployees(final List<ManagerEmployeeEntity> entities) {
        return ofNullable(entities).orElse(emptyList()).stream()
                .map(ManagerMapper::toManagerEmployee)
                .filter(Objects::nonNull)
                .toList();
    }

    public static ManagerEntity toManagerEntity(final Manager manager) {
        return Optional.ofNullable(manager)
                .map(m -> ManagerEntity.create()
                        .withId(manager.getPersonId().toString())
                        .withGivenname(m.getGivenname())
                        .withMiddlename(m.getMiddlename())
                        .withLastname(m.getLastname())
                        .withLoginname(m.getLoginname())
                        .withEmailAddress(m.getEmailAddress())
                        .withReferenceNumber(m.getReferenceNumber()))
                .orElse(null);
    }

    public static ManagerEmployeeEntity toManagerEmployeeEntity(final String managerId, final String employeeId) {
        return ManagerEmployeeEntity.create()
                .withManagerId(managerId)
                .withEmployeeId(employeeId);
    }
}