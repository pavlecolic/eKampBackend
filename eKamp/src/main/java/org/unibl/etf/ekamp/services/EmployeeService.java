package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.requests.ChangeEmployeeStatusRequest;

public interface EmployeeService extends CrudService<Integer> {
    Employee findByUsername(String username);
    void changeStatus(Integer userId, ChangeEmployeeStatusRequest request);

}
