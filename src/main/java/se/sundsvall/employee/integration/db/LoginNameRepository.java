package se.sundsvall.employee.integration.db;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.data.jpa.repository.JpaRepository;
import se.sundsvall.employee.integration.db.model.LoginNameEntity;

import java.util.List;
import java.util.Optional;

@CircuitBreaker(name = "LoginNameRepository")
public interface LoginNameRepository extends JpaRepository<LoginNameEntity, String> {
    List<LoginNameEntity> findByEmployeeId(String employeeId);
    Optional<LoginNameEntity> findByDomainAndLoginName(String domain, String loginName);
}