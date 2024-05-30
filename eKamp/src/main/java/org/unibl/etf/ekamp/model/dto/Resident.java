package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Resident extends Person {

    private Boolean needsHospitalisation;
    private String employeeJmbg;
}
