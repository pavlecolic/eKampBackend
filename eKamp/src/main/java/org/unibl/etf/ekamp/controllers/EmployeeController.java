package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.Employee;
import org.unibl.etf.ekamp.model.EmployeeRequest;
import org.unibl.etf.ekamp.model.Person;
import org.unibl.etf.ekamp.model.PersonRequest;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.services.PersonService;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends CrudController<Integer, EmployeeRequest, Employee> {

    protected EmployeeController(EmployeeService crudService) {
        super(Employee.class, crudService);
    }


}
