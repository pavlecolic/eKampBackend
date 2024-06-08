package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.UserMessages;
import org.unibl.etf.ekamp.model.requests.*;

import java.util.List;

public interface EmployeeService extends CrudService<Integer> {
    Employee findByUsername(String username);
    void changeStatus(Integer userId, ChangeEmployeeStatusRequest request);
    Employee update(Integer id, EmployeeUpdateRequest request);

    Employee signUp(EmployeeRequest request);

    Assignment changeAssignment(Integer id, ChangeAssignmentRequest assignmentRequest);
    Assignment currentAssignment(Integer id);
    List<Assignment> currentAssignments(Integer id);

    List<UserMessages> getUserMessages(Integer id);
    void setReadMessage(Integer employeeId, Integer messageId);

}
