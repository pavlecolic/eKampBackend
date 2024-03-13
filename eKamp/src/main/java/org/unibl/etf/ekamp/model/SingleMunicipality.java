package org.unibl.etf.ekamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleMunicipality extends Municipality{
    private List<PlaceEntity> places;
}
