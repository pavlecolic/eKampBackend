package org.unibl.etf.ekamp.services;

import org.springframework.web.bind.annotation.PathVariable;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;

import java.util.List;

public interface ResidencePeriodService  extends CrudService<Integer> {
     List<ResidencePeriod> getResidentResidencePeriods(Integer id);
    }
