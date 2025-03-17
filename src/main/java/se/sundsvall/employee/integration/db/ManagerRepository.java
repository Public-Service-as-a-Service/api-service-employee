package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import se.sundsvall.employee.integration.db.model.ManagerEntity;

import java.util.Optional;
import java.util.UUID;

@CircuitBreaker(name = "ManagerRepository")
public interface ManagerRepository extends JpaRepository<ManagerEntity, UUID>, JpaSpecificationExecutor<ManagerEntity> {
    Optional<ManagerEntity> findByEmailAddress(String emailAddress);
    Optional<ManagerEntity> findByLoginname(String loginname);
}