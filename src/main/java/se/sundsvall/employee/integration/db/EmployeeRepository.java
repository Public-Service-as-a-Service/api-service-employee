package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import se.sundsvall.employee.integration.db.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static se.sundsvall.employee.integration.db.specification.EmployeeSpecification.*;

@CircuitBreaker(name = "EmployeeRepository")
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String>, JpaSpecificationExecutor<EmployeeEntity> {

    default List<EmployeeEntity> findAllByFilter(final String filter) {
        return this.findAll(withFilter(filter));
    }

    default List<EmployeeEntity> findNewEmployments(final String filter) {
        return this.findAll(withFilter(filter).and(withNewEmployments()));
    }

    default List<EmployeeEntity> findEndedEmployments(final String filter) {
        return this.findAll(withFilter(filter).and(withEndedEmployments()));
    }

    Optional<EmployeeEntity> findByPersonNumber(String personNumber);

    Optional<EmployeeEntity> findById(UUID id);
}