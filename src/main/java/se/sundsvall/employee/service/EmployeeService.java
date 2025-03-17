package se.sundsvall.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import se.sundsvall.employee.api.model.*;
import se.sundsvall.employee.integration.db.*;

import java.util.List;
import java.util.UUID;

import static org.zalando.problem.Status.NOT_FOUND;
import static se.sundsvall.employee.service.mapper.EmployeeMapper.*;
import static se.sundsvall.employee.service.mapper.LoginNameMapper.toLoginNames;
import static se.sundsvall.employee.service.mapper.ManagerMapper.toManagerEmployees;
import static se.sundsvall.employee.service.mapper.PersonImageMapper.toPersonImageEntity;
import static se.sundsvall.employee.service.mapper.PortalPersonDataMapper.toPortalPersonData;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LoginNameRepository loginNameRepository;
    private final PortalPersonDataRepository portalPersonDataRepository;
    private final PersonImageRepository personImageRepository;
    private final ManagerEmployeeRepository managerEmployeeRepository;

    public EmployeeService(
            EmployeeRepository employeeRepository,
            LoginNameRepository loginNameRepository,
            PortalPersonDataRepository portalPersonDataRepository,
            PersonImageRepository personImageRepository,
            ManagerEmployeeRepository managerEmployeeRepository) {
        this.employeeRepository = employeeRepository;
        this.loginNameRepository = loginNameRepository;
        this.portalPersonDataRepository = portalPersonDataRepository;
        this.personImageRepository = personImageRepository;
        this.managerEmployeeRepository = managerEmployeeRepository;
    }

    public List<LoginName> getLoginNames(String personalNumber) {
        var employee = employeeRepository.findByPersonNumber(personalNumber)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Employee with personal number %s not found", personalNumber)));

        return toLoginNames(loginNameRepository.findByEmployeeId(employee.getId()));
    }

    public PortalPersonData getPortalPersonData(String domain, String loginName) {
        var loginNameEntity = loginNameRepository.findByDomainAndLoginName(domain, loginName)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Login name with domain %s and login name %s not found", domain, loginName)));

        var portalPersonData = portalPersonDataRepository.findByEmployeeId(loginNameEntity.getEmployeeId())
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Portal person data not found for employee")));

        return toPortalPersonData(portalPersonData);
    }

    public PortalPersonData getPortalPersonDataByEmail(String email) {
        var portalPersonData = portalPersonDataRepository.findByEmail(email)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Portal person data with email %s not found", email)));

        return toPortalPersonData(portalPersonData);
    }

    public List<Employee> getEmployments(String filter) {
        return toEmployees(employeeRepository.findAllByFilter(filter));
    }

    public List<Employee> getNewEmployments(String filter) {
        return toEmployees(employeeRepository.findNewEmployments(filter));
    }

    public List<Employee> getEndedEmployments(String filter) {
        return toEmployees(employeeRepository.findEndedEmployments(filter));
    }

    public byte[] getPersonImage(UUID personId, Integer width) {
        var personImage = personImageRepository.findByEmployeeId(personId)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Person image for person id %s not found", personId)));

        if (width != null) {
            // TODO: Implement image resize logic if needed
            return personImage.getImageData();
        }
        return personImage.getImageData();
    }

    public void updatePersonImage(UUID personId, ModelPostPersonImage image) {
        var employee = employeeRepository.findById(personId.toString())
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Employee with id %s not found", personId)));

        var personImage = personImageRepository.findByEmployeeId(personId)
                .orElse(toPersonImageEntity(image)
                        .withEmployeeId(employee.getId()));

        personImage.setTitle(image.getTitle());
        personImage.setImageData(image.getImageData().getBytes());

        personImageRepository.save(personImage);
    }

    public void deletePersonImage(UUID personId) {
        if (!personImageRepository.existsByEmployeeId(personId)) {
            throw Problem.valueOf(NOT_FOUND,
                    String.format("Person image for person id %s not found", personId));
        }

        personImageRepository.deleteByEmployeeId(personId);
    }

    public List<ManagerEmployee> getManagerEmployees(UUID managerId) {
        return toManagerEmployees(managerEmployeeRepository.findByManagerId(managerId));
    }
}