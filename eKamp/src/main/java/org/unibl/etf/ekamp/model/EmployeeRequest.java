package org.unibl.etf.ekamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmployeeRequest extends PersonRequest {
    private String password;
    private String username;
}
