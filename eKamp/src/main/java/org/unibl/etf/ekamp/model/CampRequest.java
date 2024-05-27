package org.unibl.etf.ekamp.model;

import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CampStatusEntity;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
@Data

public class CampRequest {

    private String name;
    private Integer capacity;
    private Integer placeId;
    private Integer campStatusId;

}
