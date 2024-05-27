package org.unibl.etf.ekamp.model.dto;

import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;

import java.util.List;

public class SingleCamp extends Camp {
    private List<ResidencePeriod> residencePeriods;
    private List<Assignment> assignments;

}
