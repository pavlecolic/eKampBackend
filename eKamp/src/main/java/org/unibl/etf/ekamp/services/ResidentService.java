package org.unibl.etf.ekamp.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;


public interface ResidentService extends CrudService<Integer> {

    void depart(DepartureRequest request);
    Resident addResident(ResidentRequest request);
    Page<Resident> findAll(Pageable pageable);
}
