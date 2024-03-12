package org.unibl.etf.ekamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ResidentRequest extends PersonRequest {
    private Boolean needsHospitalisation;
    private Integer employeeId;
}
