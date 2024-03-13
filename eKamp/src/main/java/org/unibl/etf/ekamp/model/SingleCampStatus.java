package org.unibl.etf.ekamp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.entities.CampEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleCampStatus extends CampStatus {
    // TODO: dodati prikaz
    private List<CampEntity> camps;

}
