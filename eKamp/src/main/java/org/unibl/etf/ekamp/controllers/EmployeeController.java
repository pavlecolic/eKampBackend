package org.unibl.etf.ekamp.controllers;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.exceptions.ForbiddenException;
import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;
import org.unibl.etf.ekamp.model.dto.UserMessages;
import org.unibl.etf.ekamp.model.requests.*;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.model.enums.Role;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

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
        if (jwtUser.getRole() != Role.ADMIN)
            throw new ForbiddenException();
        service.changeStatus(id, request);
    }
    @GetMapping("/{id}")
    public Employee get(@PathVariable Integer id) {
        return service.findById(id, Employee.class);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Integer id, @Valid @RequestBody EmployeeUpdateRequest request, Authentication auth) {
        JwtEmployee jwtUser = (JwtEmployee) auth.getPrincipal();
        // prijavljeni korisnik mora da bude administrator da bi izmijenio volonterski nalog
        if (jwtUser.getRole() != Role.ADMIN)
            throw new ForbiddenException();
        return service.update(id, request);
    }

    @PostMapping
    public Employee signUp(@Valid @RequestBody EmployeeRequest request, Authentication authentication) {
        JwtEmployee jwtEmployee = (JwtEmployee) authentication.getPrincipal();
        if (jwtEmployee.getRole() != Role.ADMIN)
            throw new ForbiddenException();
        return service.signUp(request);
    }

    @PutMapping("/{id}/change-assignment")
    public Assignment changeAssignment(@PathVariable Integer id, @Valid @RequestBody ChangeAssignmentRequest assignmentRequest, Authentication authentication) {
        JwtEmployee jwtEmployee = (JwtEmployee) authentication.getPrincipal();
        if(jwtEmployee.getRole() != Role.ADMIN)
            throw new ForbiddenException();
        return service.changeAssignment(id, assignmentRequest);
    }

    @GetMapping("/{id}/assignment")
    public Assignment currentAssignment(@PathVariable Integer id) {
        return service.currentAssignment(id);
    }

    @GetMapping("/{id}/assignments")
    public List<Assignment> currentAssignments(@PathVariable Integer id) {
        return service.currentAssignments(id);
    }

    @GetMapping("/{id}/messages")
    public List<UserMessages> getUserMessages(@PathVariable Integer id) {
        return service.getUserMessages(id);
    }

    @PatchMapping("/{employee_id}/messages/{message_id}")
    public void setReadMessage(@PathVariable("employee_id") Integer employeeId, @PathVariable("message_id") Integer messageId) {
        service.setReadMessage(employeeId, messageId);
    }

}
