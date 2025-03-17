package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.employee.integration.db.model.PersonImageEntity;

import java.util.Optional;
import java.util.UUID;

@CircuitBreaker(name = "PersonImageRepository")
public interface PersonImageRepository extends JpaRepository<PersonImageEntity, String> {
    Optional<PersonImageEntity> findByEmployeeId(UUID employeeId);
    void deleteByEmployeeId(UUID employeeId);
    boolean existsByEmployeeId(UUID employeeId);
}