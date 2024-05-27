package org.unibl.etf.ekamp.model.requests;

import lombok.Data;

@Data
public class PlaceRequest {
    private String description;
    private Integer municipalityId;
}
