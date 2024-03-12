package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.base.BaseEntity;
import org.unibl.etf.ekamp.model.entities.MunicipilityEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;

import java.util.List;
@Data
public class Country {

        private Integer id;

        private String name;



}
