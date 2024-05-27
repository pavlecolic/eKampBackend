package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class SinglePlace extends Place {
    private List<Camp> camps;

}
