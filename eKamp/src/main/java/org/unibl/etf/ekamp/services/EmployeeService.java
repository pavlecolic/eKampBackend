package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.requests.ChangeEmployeeStatusRequest;
import org.unibl.etf.ekamp.model.requests.EmployeeRequest;
import org.unibl.etf.ekamp.model.requests.EmployeeUpdateRequest;

public interface EmployeeService extends CrudService<Integer> {
    Employee findByUsername(String username);
    void changeStatus(Integer userId, ChangeEmployeeStatusRequest request);
    Employee update(Integer id, EmployeeUpdateRequest request);

    Employee signUp(EmployeeRequest request);

}
