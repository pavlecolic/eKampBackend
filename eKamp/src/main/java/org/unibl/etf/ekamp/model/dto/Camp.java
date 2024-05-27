package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.CampStatusEntity;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;

import java.util.List;
@Data
public class Camp {

    private Integer id;
    private String name;
    private Integer capacity;
    // TODO: da li treba jos info o lokaciji
    private String placeDescription;
    private String campStatusName;
}
