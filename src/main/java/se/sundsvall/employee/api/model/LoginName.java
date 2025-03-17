package se.sundsvall.employee.api.model;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(NON_NULL)
@Schema(description = "Login name model")
public class LoginName {

    @Schema(description = "Domain", example = "example.com")
    private String domain;

    @Schema(description = "Login name", example = "Anders.Andersson")
    private String loginName;

    public static LoginName create() {
        return new LoginName();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public LoginName withDomain(String domain) {
        this.domain = domain;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public LoginName withLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(domain, loginName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        LoginName other = (LoginName) obj;
        return Objects.equals(domain, other.domain) &&
                Objects.equals(loginName, other.loginName);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("LoginName [domain=").append(domain)
                .append(", loginName=").append(loginName)
                .append("]").toString();
    }
}