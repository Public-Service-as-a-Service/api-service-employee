package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.employee.integration.db.model.PortalPersonDataEntity;

import java.util.Optional;

@CircuitBreaker(name = "PortalPersonDataRepository")
public interface PortalPersonDataRepository extends JpaRepository<PortalPersonDataEntity, String> {
    Optional<PortalPersonDataEntity> findByEmail(String email);
    Optional<PortalPersonDataEntity> findByEmployeeId(String employeeId);
}