package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SingleMunicipality extends Municipality {
    private List<Place> places;
}
