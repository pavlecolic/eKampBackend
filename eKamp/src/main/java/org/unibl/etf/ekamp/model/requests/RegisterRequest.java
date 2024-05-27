package org.unibl.etf.ekamp.model.requests;

import java.sql.Date;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String jmbg;
    private  String country_id;
    private String username;
    private String password;
}
