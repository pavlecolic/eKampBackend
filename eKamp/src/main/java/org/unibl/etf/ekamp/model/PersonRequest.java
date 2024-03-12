package org.unibl.etf.ekamp.model;

import lombok.Data;

import java.sql.Date;

@Data
public class PersonRequest {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String jmbg;
    //    private EmployeeEntity employee;
    private Integer countryId;
//    private ResidentEntity resident;
}
