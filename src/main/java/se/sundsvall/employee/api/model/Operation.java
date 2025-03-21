package se.sundsvall.employee.api.model;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Operation model")
public class Operation {

    @Schema(description = "Type of operation", example = "replace")
    private String op;

    @Schema(description = "Path to attribute", example = "/name/firstName")
    private String path;

    @Schema(description = "Value of attribute", example = "John")
    private String value;

    @Schema(description = "Previous value of attribute", example = "John")
    private String fromValue;

    public static Operation create() {
        return new Operation();
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public Operation withOp(String op) {
        this.op = op;
        return this;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Operation withPath(String path) {
        this.path = path;
        return this;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Operation withValue(String value) {
        this.value = value;
        return this;
    }

    public String getFromValue() {
        return fromValue;
    }

    public void setFromValue(String fromValue) {
        this.fromValue = fromValue;
    }

    public Operation withFromValue(String fromValue) {
        this.fromValue = fromValue;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(op, path, value, fromValue);
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
        Operation other = (Operation) obj;
        return Objects.equals(op, other.op) && Objects.equals(path, other.path) && Objects.equals(value, other.value) && Objects.equals(fromValue, other.fromValue);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Operation [op=");
        builder.append(op);
        builder.append(", path=");
        builder.append(path);
        builder.append(", value=");
        builder.append(value);
        builder.append(", fromValue=");
        builder.append(fromValue);
        builder.append("]");
        return builder.toString();
    }
}
