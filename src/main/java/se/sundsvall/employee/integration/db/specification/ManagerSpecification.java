package se.sundsvall.employee.integration.db.specification;

import org.springframework.data.jpa.domain.Specification;
import se.sundsvall.employee.integration.db.model.ManagerEntity;

import static java.util.Objects.nonNull;

public interface ManagerSpecification {

    static Specification<ManagerEntity> withEmail(String email) {
        return buildEqualFilter("emailAddress", email);
    }

    static Specification<ManagerEntity> withLoginName(String loginName) {
        return buildEqualFilter("loginname", loginName);
    }

    static Specification<ManagerEntity> withReferenceNumber(String referenceNumber) {
        return buildEqualFilter("referenceNumber", referenceNumber);
    }

    /**
     * Method builds an equal filter if value is not null. If value is null, method returns
     * an always-true predicate (meaning no filtering will be applied for sent in attribute)
     *
     * @param  attribute name that will be used in filter
     * @param  value     value (or null) to compare against
     * @return           {@code Specification<ManagerEntity>} matching sent in comparison
     */
    private static Specification<ManagerEntity> buildEqualFilter(String attribute, Object value) {
        return (managerEntity, cq, cb) -> nonNull(value) ? cb.equal(managerEntity.get(attribute), value) : cb.and();
    }
}