package org.unibl.etf.ekamp.model.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;

@Data
public class PersonRequest {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    @NotNull
    private String jmbg;
    //    private EmployeeEntity employee;
    @NotNull
    private Integer countryId;
//    private ResidentEntity resident;
}
