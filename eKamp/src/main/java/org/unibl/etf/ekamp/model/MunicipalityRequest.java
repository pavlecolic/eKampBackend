package org.unibl.etf.ekamp.model;

import lombok.Data;

@Data
public class MunicipalityRequest {
    private String name;
    private String postCode;
    private Integer countryId;
}
