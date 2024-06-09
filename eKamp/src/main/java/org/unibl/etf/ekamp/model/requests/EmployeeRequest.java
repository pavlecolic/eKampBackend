package org.unibl.etf.ekamp.model.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.requests.PersonRequest;
import org.unibl.etf.ekamp.model.enums.Role;


@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeRequest extends PersonRequest {
    @NotNull
    private String password;
    @NotNull
    private String username;
}
