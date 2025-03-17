package se.sundsvall.employee.service.mapper;

import se.sundsvall.employee.api.model.PortalPersonData;
import se.sundsvall.employee.integration.db.model.PortalPersonDataEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public class PortalPersonDataMapper {

    private PortalPersonDataMapper() {}

    public static PortalPersonData toPortalPersonData(final PortalPersonDataEntity entity) {
        return Optional.ofNullable(entity)
                .map(e -> PortalPersonData.create()
                        .withPersonid(UUID.fromString(e.getEmployeeId()))
                        .withGivenname(e.getGivenname())
                        .withLastname(e.getLastname())
                        .withFullname(e.getFullname())
                        .withAddress(e.getAddress())
                        .withPostalCode(e.getPostalCode())
                        .withCity(e.getCity())
                        .withWorkPhone(e.getWorkPhone())
                        .withMobilePhone(e.getMobilePhone())
                        .withExtraMobilePhone(e.getExtraMobilePhone())
                        .withAboutMe(e.getAboutMe())
                        .withEmail(e.getEmail())
                        .withMailNickname(e.getMailNickname())
                        .withCompany(e.getCompany())
                        .withCompanyId(e.getCompanyId())
                        .withOrgTree(e.getOrgTree())
                        .withReferenceNumber(e.getReferenceNumber())
                        .withManager(e.getIsManager())
                        .withLoginName(e.getLoginname()))
                .orElse(null);
    }

    public static List<PortalPersonData> toPortalPersonDataList(final List<PortalPersonDataEntity> entities) {
        return ofNullable(entities).orElse(emptyList()).stream()
                .map(PortalPersonDataMapper::toPortalPersonData)
                .filter(Objects::nonNull)
                .toList();
    }

    public static PortalPersonDataEntity toPortalPersonDataEntity(final PortalPersonData portalPersonData) {
        return Optional.ofNullable(portalPersonData)
                .map(p -> PortalPersonDataEntity.create()
                        .withEmployeeId(p.getPersonid().toString())
                        .withFullname(p.getFullname())
                        .withAddress(p.getAddress())
                        .withPostalCode(p.getPostalCode())
                        .withCity(p.getCity())
                        .withWorkPhone(p.getWorkPhone())
                        .withMobilePhone(p.getMobilePhone())
                        .withExtraMobilePhone(p.getExtraMobilePhone())
                        .withAboutMe(p.getAboutMe())
                        .withEmail(p.getEmail())
                        .withMailNickname(p.getMailNickname())
                        .withCompany(p.getCompany())
                        .withCompanyId(p.getCompanyId())
                        .withOrgTree(p.getOrgTree())
                        .withReferenceNumber(p.getReferenceNumber())
                        .withIsManager(p.isManager())
                        .withLoginname(p.getLoginName()))
                .orElse(null);
    }
}