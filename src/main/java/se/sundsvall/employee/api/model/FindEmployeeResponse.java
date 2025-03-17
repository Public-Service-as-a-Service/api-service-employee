package se.sundsvall.employee.api.model;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "FindEmployeeResponse model")
public class FindEmployeeResponse {

    @JsonProperty("_meta")
    @Schema(implementation = MetaData.class, accessMode = READ_ONLY)
    private MetaData metaData;

    @ArraySchema(schema = @Schema(implementation = Employee.class, accessMode = READ_ONLY))
    private List<Employee> employees;

    public static FindEmployeeResponse create() {
        return new FindEmployeeResponse();
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public FindEmployeeResponse withMetaData(MetaData metaData) {
        this.metaData = metaData;
        return this;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public FindEmployeeResponse withEmployees(List<Employee> employees) {
        this.employees = employees;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees, metaData);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FindEmployeeResponse other = (FindEmployeeResponse) obj;
        return Objects.equals(employees, other.employees) && Objects.equals(metaData, other.metaData);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("FindEmployeeResponse [metaData=").append(metaData)
                .append(", employees=").append(employees)
                .append("]");
        return builder.toString();
    }
}