package se.sundsvall.employee.integration.db.specification;

import org.springframework.data.jpa.domain.Specification;
import se.sundsvall.employee.integration.db.model.PortalPersonDataEntity;

import static java.util.Objects.nonNull;

public interface PortalPersonDataSpecification {

    static Specification<PortalPersonDataEntity> withEmail(String email) {
        return buildEqualFilter("email", email);
    }

    static Specification<PortalPersonDataEntity> withLoginName(String loginName) {
        return buildEqualFilter("loginName", loginName);
    }

    static Specification<PortalPersonDataEntity> withDomain(String domain) {
        return buildEqualFilter("domain", domain);
    }

    static Specification<PortalPersonDataEntity> withEmployeeId(String employeeId) {
        return buildEqualFilter("employeeId", employeeId);
    }

    static Specification<PortalPersonDataEntity> withIsManager(Boolean isManager) {
        return buildEqualFilter("isManager", isManager);
    }

    /**
     * Method builds an equal filter if value is not null. If value is null, method returns
     * an always-true predicate (meaning no filtering will be applied for sent in attribute)
     *
     * @param  attribute name that will be used in filter
     * @param  value     value (or null) to compare against
     * @return           {@code Specification<PortalPersonDataEntity>} matching sent in comparison
     */
    private static Specification<PortalPersonDataEntity> buildEqualFilter(String attribute, Object value) {
        return (portalPersonDataEntity, cq, cb) -> nonNull(value) ? cb.equal(portalPersonDataEntity.get(attribute), value) : cb.and();
    }
}