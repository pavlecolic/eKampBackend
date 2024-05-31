package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.requests.*;

public interface EmployeeService extends CrudService<Integer> {
    Employee findByUsername(String username);
    void changeStatus(Integer userId, ChangeEmployeeStatusRequest request);
    Employee update(Integer id, EmployeeUpdateRequest request);

    Employee signUp(EmployeeRequest request);

    Assignment changeAssignment(Integer id, ChangeAssignmentRequest assignmentRequest);

}
