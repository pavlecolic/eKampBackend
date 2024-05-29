package org.unibl.etf.ekamp.controllers;

import io.jsonwebtoken.Jwt;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.exceptions.ForbiddenException;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.requests.ChangeEmployeeStatusRequest;
import org.unibl.etf.ekamp.model.requests.EmployeeRequest;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.services.PersonService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> getAll() {
        return service.findAll(Employee.class);
    }

    @PatchMapping("/{id}/status")
    public void changeStatus(@PathVariable Integer id, @RequestBody @Valid ChangeEmployeeStatusRequest request, Authentication auth) {
        JwtEmployee jwtUser = (JwtEmployee) auth.getPrincipal();
        if (jwtUser.getId().equals(id))
            throw new ForbiddenException();
        service.changeStatus(id, request);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @Valid @RequestBody EmployeeRequest request, Authentication auth) {
        JwtEmployee jwtUser = (JwtEmployee) auth.getPrincipal();
        if (!jwtUser.getId().equals(id))
            throw new ForbiddenException();
        return service.update(id, request, Employee.class);
    }

    // dodati GET I POST

}
