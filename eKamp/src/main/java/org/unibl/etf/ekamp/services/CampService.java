package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.CampStatusRequest;

import java.util.List;

public interface CampService extends CrudService<Integer> {

    Camp findByName(String name);
    List<ResidencePeriod> campResidencePeriods(Integer id);
    List<Resident> getAllCampResidents(Integer id);
    List<Resident> getAllCampResidentsEver(Integer id);
    void changeCampStatus(Integer id, CampStatusRequest request);

    List<Employee> getAllVolunteers(Integer id);
}
