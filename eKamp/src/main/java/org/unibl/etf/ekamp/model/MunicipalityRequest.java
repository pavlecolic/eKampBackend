package org.unibl.etf.ekamp.model;

import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CountryEntity;

@Data
public class MunicipalityRequest {
    private String name;
    private String postCode;
    private Integer countryId;
}
