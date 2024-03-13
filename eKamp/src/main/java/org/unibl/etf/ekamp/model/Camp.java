package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.CampStatusEntity;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;

import java.util.List;

public class Camp {

    private Integer id;
    private String name;
    private Integer capacity;
    private PlaceEntity place;
    private CampStatusEntity campStatus;


}
