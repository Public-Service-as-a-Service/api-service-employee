package se.sundsvall.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import se.sundsvall.employee.api.model.ManagerEmployee;
import se.sundsvall.employee.api.model.Manager;
import se.sundsvall.employee.integration.db.ManagerRepository;
import se.sundsvall.employee.integration.db.ManagerEmployeeRepository;
import se.sundsvall.employee.service.mapper.ManagerMapper;

import java.util.List;
import java.util.UUID;

import static org.zalando.problem.Status.NOT_FOUND;
import static se.sundsvall.employee.service.mapper.ManagerMapper.toManagerEmployees;

@Service
@Transactional
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final ManagerEmployeeRepository managerEmployeeRepository;

    public ManagerService(ManagerRepository managerRepository,
                          ManagerEmployeeRepository managerEmployeeRepository) {
        this.managerRepository = managerRepository;
        this.managerEmployeeRepository = managerEmployeeRepository;
    }

    public List<ManagerEmployee> getManagerEmployees(UUID managerId) {
        var manager = managerRepository.findById(managerId)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Manager with id %s not found", managerId)));

        return toManagerEmployees(managerEmployeeRepository.findByManagerId(managerId));
    }

    public Manager getManager(UUID managerId) {
        return managerRepository.findById(managerId)
                .map(ManagerMapper::toManager)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Manager with id %s not found", managerId)));
    }

    public Manager getManagerByEmail(String email) {
        return managerRepository.findByEmailAddress(email)
                .map(ManagerMapper::toManager)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Manager with email %s not found", email)));
    }

    public boolean isManager(UUID employeeId) {
        var managerEmployees = managerEmployeeRepository.findByEmployeeId(employeeId);
        return !managerEmployees.isEmpty();
    }
}