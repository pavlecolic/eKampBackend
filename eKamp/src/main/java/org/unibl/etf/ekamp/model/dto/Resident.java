package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Resident extends Person {

    private Boolean needsHospitalisation;
    // Maticni employee-a koji ga je dodao u kamp, po potrebi moze i Employee objekat
    private String employeeJmbg;

}
