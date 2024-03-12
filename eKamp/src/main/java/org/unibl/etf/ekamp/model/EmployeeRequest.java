package org.unibl.etf.ekamp.model;

import lombok.Data;

@Data
public class EmployeeRequest extends PersonRequest {
    private String password;
    private String username;

}
