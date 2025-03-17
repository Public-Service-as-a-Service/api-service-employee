package se.sundsvall.employee.api.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.Objects;

import static java.lang.Integer.parseInt;

@Schema(description = "FindEmployeeRequest model")
public class FindEmployeeRequest {
    private static final String DEFAULT_PAGE = "1";
    private static final String DEFAULT_LIMIT = "100";

    @Schema(description = "Filter string for employee search")
    private String filter;

    @Schema(description = "Page number", example = DEFAULT_PAGE, defaultValue = DEFAULT_PAGE)
    @Min(1)
    protected int page = parseInt(DEFAULT_PAGE);

    @Schema(description = "Result size per page", example = DEFAULT_LIMIT, defaultValue = DEFAULT_LIMIT)
    @Min(1)
    @Max(1000)
    protected int limit = parseInt(DEFAULT_LIMIT);

    public static FindEmployeeRequest create() {
        return new FindEmployeeRequest();
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public FindEmployeeRequest withFilter(String filter) {
        this.filter = filter;
        return this;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public FindEmployeeRequest withPage(int page) {
        this.page = page;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public FindEmployeeRequest withLimit(int limit) {
        this.limit = limit;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(filter, limit, page);
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
        FindEmployeeRequest other = (FindEmployeeRequest) obj;
        return Objects.equals(filter, other.filter)
                && limit == other.limit
                && page == other.page;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("FindEmployeeRequest [filter=").append(filter)
                .append(", page=").append(page)
                .append(", limit=").append(limit)
                .append("]")
                .toString();
    }
}