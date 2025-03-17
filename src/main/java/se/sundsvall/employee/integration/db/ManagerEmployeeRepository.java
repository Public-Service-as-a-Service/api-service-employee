package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.employee.integration.db.model.ManagerEmployeeEntity;

import java.util.List;
import java.util.UUID;

@CircuitBreaker(name = "ManagerEmployeeRepository")
public interface ManagerEmployeeRepository extends JpaRepository<ManagerEmployeeEntity, UUID> {
    List<ManagerEmployeeEntity> findByManagerId(UUID managerId);
    List<ManagerEmployeeEntity> findByEmployeeId(UUID employeeId);
}