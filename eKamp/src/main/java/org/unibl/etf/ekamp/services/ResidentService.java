package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;


public interface ResidentService extends CrudService<Integer> {

    void depart(DepartureRequest request);
}
