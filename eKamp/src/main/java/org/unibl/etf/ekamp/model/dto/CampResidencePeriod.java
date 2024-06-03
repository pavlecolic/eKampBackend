package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
public class CampResidencePeriod extends ResidencePeriod {

    private Boolean residentNeedsHospitalisation;
    private String residentEmployeeFirstName;
    private String residentEmployeeLastName;

}
