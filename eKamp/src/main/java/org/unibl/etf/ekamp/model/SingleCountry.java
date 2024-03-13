package org.unibl.etf.ekamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.entities.MunicipalityEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleCountry extends Country {
    private List<MunicipalityEntity> municipilities;
    private List<PersonEntity> people;

}
