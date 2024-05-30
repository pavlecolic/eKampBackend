package org.unibl.etf.ekamp.model.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeUpdateRequest {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Integer countryId;
    private String username;
    private String jmbg;
    private String sex;
}
