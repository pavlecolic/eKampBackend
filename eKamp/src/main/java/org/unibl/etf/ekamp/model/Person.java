package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String jmbg;
//    private EmployeeEntity employee;
    private String countryName;
//    private ResidentEntity resident;
}
