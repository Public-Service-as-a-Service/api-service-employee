package se.sundsvall.employee.integration.db.specification;

import org.springframework.data.jpa.domain.Specification;
import se.sundsvall.employee.integration.db.model.EmployeeEntity;

import java.time.LocalDateTime;

import static java.util.Objects.nonNull;

public interface EmployeeSpecification {

    static Specification<EmployeeEntity> withFilter(String filter) {
        return (root, query, cb) -> {
            if (nonNull(filter)) {
                String likeFilter = "%" + filter.toLowerCase() + "%";
                return cb.or(
                        cb.like(cb.lower(root.get("givenname")), likeFilter),
                        cb.like(cb.lower(root.get("lastname")), likeFilter),
                        cb.like(cb.lower(root.get("loginname")), likeFilter),
                        cb.like(cb.lower(root.get("emailAddress")), likeFilter)
                );
            }
            return cb.and();
        };
    }

    static Specification<EmployeeEntity> withNewEmployments() {
        return (root, query, cb) -> {
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime oneMonthAgo = now.minusMonths(1);
            return cb.between(root.get("startDate"), oneMonthAgo, now);
        };
    }

    static Specification<EmployeeEntity> withEndedEmployments() {
        return (root, query, cb) -> {
            LocalDateTime now = LocalDateTime.now();
            return cb.lessThanOrEqualTo(root.get("endDate"), now);
        };
    }

    private static Specification<EmployeeEntity> buildEqualFilter(String attribute, Object value) {
        return (employeeEntity, cq, cb) -> nonNull(value) ?
                cb.equal(employeeEntity.get(attribute), value) : cb.and();
    }
}