package org.unibl.etf.ekamp.model;

import lombok.Data;
import org.unibl.etf.ekamp.model.entities.MunicipilityEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;

import java.util.List;

@Data
public class SingleCountry extends Country{
    private List<MunicipilityEntity> municipilities;

    private List<PersonEntity> people;

}
