package org.unibl.etf.ekamp.model;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String sex;
    private String jmbg;
    private Integer countryId;
    private String username;

    // Constructors, getters, and setters
}

