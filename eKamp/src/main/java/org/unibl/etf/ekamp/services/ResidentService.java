package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;

import java.util.List;

public interface ResidentService extends CrudService<Integer> {

    void depart(Integer id);
}
