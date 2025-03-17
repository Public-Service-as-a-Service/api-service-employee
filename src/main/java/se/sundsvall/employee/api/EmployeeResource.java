package se.sundsvall.employee.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zalando.problem.Problem;
import org.zalando.problem.violations.ConstraintViolationProblem;
import se.sundsvall.employee.api.model.*;
import se.sundsvall.employee.service.EmployeeService;

import java.util.List;
import java.util.UUID;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_PROBLEM_JSON_VALUE;

@RestController
@Validated
@RequestMapping("/api/v1/employee")
@Tag(name = "Employee", description = "Handles information about employees")
@ApiResponse(responseCode = "400", description = "Bad request", content = @Content(mediaType = APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(oneOf = {
        Problem.class, ConstraintViolationProblem.class
})))
@ApiResponse(responseCode = "500", description = "Internal Server error", content = @Content(mediaType = APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(implementation = Problem.class)))
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employed/{personalNumber}/loginname", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get login names for personal number")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(mediaType = APPLICATION_PROBLEM_JSON_VALUE, schema = @Schema(implementation = Problem.class)))
    public ResponseEntity<List<LoginName>> getLoginNames(
            @Parameter(description = "Personal number") @PathVariable String personalNumber) {
        return ResponseEntity.ok(employeeService.getLoginNames(personalNumber));
    }

    @GetMapping(path = "/portalpersondata/{domain}/{loginName}", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get portal person data by domain and login name")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<PortalPersonData> getPortalPersonData(
            @Parameter(description = "Domain") @PathVariable String domain,
            @Parameter(description = "Login name") @PathVariable String loginName) {
        return ResponseEntity.ok(employeeService.getPortalPersonData(domain, loginName));
    }

    @GetMapping(path = "/portalpersondata/{email}", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get portal person data by email")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<PortalPersonData> getPortalPersonDataByEmail(
            @Parameter(description = "Email address") @PathVariable String email) {
        return ResponseEntity.ok(employeeService.getPortalPersonDataByEmail(email));
    }

    @GetMapping(path = "/employments", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get employments")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<List<Employee>> getEmployments(
            @Parameter(description = "Filter") @RequestParam(required = false) String filter) {
        return ResponseEntity.ok(employeeService.getEmployments(filter));
    }

    @GetMapping(path = "/{personId}/personimage", produces = ALL_VALUE)
    @Operation(summary = "Get person image")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<byte[]> getPersonImage(
            @Parameter(description = "Person ID") @PathVariable UUID personId,
            @Parameter(description = "Image width") @RequestParam(required = false) Integer width) {
        return ResponseEntity.ok(employeeService.getPersonImage(personId, width));
    }

    @PutMapping(path = "/{personId}/personimage", consumes = APPLICATION_JSON_VALUE)
    @Operation(summary = "Update person image")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Void> updatePersonImage(
            @Parameter(description = "Person ID") @PathVariable UUID personId,
            @Valid @NotNull @RequestBody ModelPostPersonImage image) {
        employeeService.updatePersonImage(personId, image);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/{personId}/personimage")
    @Operation(summary = "Delete person image")
    @ApiResponse(responseCode = "200", description = "Success")
    public ResponseEntity<Void> deletePersonImage(
            @Parameter(description = "Person ID") @PathVariable UUID personId) {
        employeeService.deletePersonImage(personId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/manageremployees/{managerId}", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get manager's employees")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<List<ManagerEmployee>> getManagerEmployees(
            @Parameter(description = "Manager ID") @PathVariable UUID managerId) {
        return ResponseEntity.ok(employeeService.getManagerEmployees(managerId));
    }

    @GetMapping(path = "/newemployments", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get new employments")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<List<Employee>> getNewEmployments(
            @Parameter(description = "Filter") @RequestParam(required = false) String filter) {
        return ResponseEntity.ok(employeeService.getNewEmployments(filter));
    }

    @GetMapping(path = "/endedemployments", produces = {
            APPLICATION_JSON_VALUE, APPLICATION_PROBLEM_JSON_VALUE
    })
    @Operation(summary = "Get ended employments")
    @ApiResponse(responseCode = "200", description = "Success", useReturnTypeSchema = true)
    public ResponseEntity<List<Employee>> getEndedEmployments(
            @Parameter(description = "Filter") @RequestParam(required = false) String filter) {
        return ResponseEntity.ok(employeeService.getEndedEmployments(filter));
    }
}