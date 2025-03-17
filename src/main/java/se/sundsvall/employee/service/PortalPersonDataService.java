package se.sundsvall.employee.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.zalando.problem.Problem;
import se.sundsvall.employee.api.model.PortalPersonData;
import se.sundsvall.employee.integration.db.LoginNameRepository;
import se.sundsvall.employee.integration.db.PortalPersonDataRepository;

import static org.zalando.problem.Status.NOT_FOUND;
import static se.sundsvall.employee.service.mapper.PortalPersonDataMapper.toPortalPersonData;

@Service
@Transactional
public class PortalPersonDataService {

    private final PortalPersonDataRepository portalPersonDataRepository;
    private final LoginNameRepository loginNameRepository;

    public PortalPersonDataService(PortalPersonDataRepository portalPersonDataRepository,
                                   LoginNameRepository loginNameRepository) {
        this.portalPersonDataRepository = portalPersonDataRepository;
        this.loginNameRepository = loginNameRepository;
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

    public PortalPersonData getPortalPersonDataByEmployeeId(String employeeId) {
        var portalPersonData = portalPersonDataRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> Problem.valueOf(NOT_FOUND,
                        String.format("Portal person data with employee id %s not found", employeeId)));

        return toPortalPersonData(portalPersonData);
    }
}