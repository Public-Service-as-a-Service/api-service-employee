package se.sundsvall.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import se.sundsvall.employee.api.model.LoginName;
import se.sundsvall.employee.integration.db.LoginNameRepository;
import se.sundsvall.employee.integration.db.EmployeeRepository;
import static se.sundsvall.employee.service.mapper.LoginNameMapper.toLoginName;
import static se.sundsvall.employee.service.mapper.LoginNameMapper.toLoginNames;

import java.util.List;

import static org.zalando.problem.Status.NOT_FOUND;

@Service
@Transactional
public class LoginNameService {

    private final LoginNameRepository loginNameRepository;
    private final EmployeeRepository employeeRepository;

    public LoginNameService(LoginNameRepository loginNameRepository, EmployeeRepository employeeRepository) {
        this.loginNameRepository = loginNameRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<LoginName> getLoginNamesByPersonalNumber(String personalNumber) {
        var employee = employeeRepository.findByPersonNumber(personalNumber)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Employee with personal number %s not found", personalNumber)));

        return toLoginNames(loginNameRepository.findByEmployeeId(employee.getId()));
    }

    public List<LoginName> getLoginNamesByEmployeeId(String employeeId) {
        if (!employeeRepository.existsById(employeeId)) {
            throw Problem.valueOf(NOT_FOUND,
                    String.format("Employee with id %s not found", employeeId));
        }

        return toLoginNames(loginNameRepository.findByEmployeeId(employeeId));
    }

    public List<LoginName> findByDomainAndLoginName(String domain, String loginName) {
        var loginNameEntity = loginNameRepository.findByDomainAndLoginName(domain, loginName)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Login name with domain %s and login name %s not found", domain, loginName)));

        return List.of(toLoginName(loginNameEntity));
    }
}