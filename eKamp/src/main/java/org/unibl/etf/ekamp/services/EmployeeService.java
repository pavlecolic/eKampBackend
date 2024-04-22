package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.Employee;

public interface EmployeeService extends CrudService<Integer> {
    Employee findByUsername(String username);
}
