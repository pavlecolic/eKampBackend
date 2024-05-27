package org.unibl.etf.ekamp.model.dto;

import lombok.Data;

@Data
public class Municipality {
    private Integer id;
    private String name;
    private String postCode;
    private String countryName;
}
