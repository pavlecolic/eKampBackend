package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.Camp;

public interface CampService extends CrudService<Integer> {

    Camp findByName(String name);
}