package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.dto.CampResidencePeriod;

import java.util.List;

public interface CampService extends CrudService<Integer> {

    Camp findByName(String name);
    List<CampResidencePeriod> campResidencePeriods(Integer id);
}
