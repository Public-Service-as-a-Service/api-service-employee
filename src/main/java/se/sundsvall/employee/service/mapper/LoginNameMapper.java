package se.sundsvall.employee.service.mapper;

import se.sundsvall.employee.api.model.LoginName;
import se.sundsvall.employee.integration.db.model.LoginNameEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class LoginNameMapper {

    private LoginNameMapper() {}

    public static LoginName toLoginName(LoginNameEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> LoginName.create()
                        .withDomain(e.getDomain())
                        .withLoginName(e.getLoginName()))
                .orElse(null);
    }

    public static List<LoginName> toLoginNames(final List<LoginNameEntity> entities) {
        return ofNullable(entities).orElse(emptyList()).stream()
                .map(LoginNameMapper::toLoginName)
                .filter(Objects::nonNull)
                .toList();
    }

    public static LoginNameEntity toLoginNameEntity(final LoginName loginName, final String employeeId) {
        return Optional.ofNullable(loginName)
                .map(l -> LoginNameEntity.create()
                        .withEmployeeId(employeeId)
                        .withDomain(l.getDomain())
                        .withLoginName(l.getLoginName()))
                .orElse(null);
    }
}