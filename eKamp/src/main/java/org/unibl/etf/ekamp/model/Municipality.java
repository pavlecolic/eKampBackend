package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CountryEntity;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;

import java.util.List;

@Data
public class Municipality {
    private Integer id;
    private String name;
    private String postCode;
    private String countryName;
}
