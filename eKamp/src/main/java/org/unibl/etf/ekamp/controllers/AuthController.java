package org.unibl.etf.ekamp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.model.Employee;
import org.unibl.etf.ekamp.model.EmployeeRequest;
import org.unibl.etf.ekamp.services.EmployeeService;

import java.util.Map;

@RestController
public class AuthController {

    private final EmployeeService employeeService;

    public AuthController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody EmployeeRequest loginRequest) {
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        Employee employee = employeeService.findByUsername(username);
        if (employee != null && employee.getPassword().equals(password)) {
            boolean isAdmin = employee.getIsAdmin();
            return ResponseEntity.ok().body(Map.of("isAdmin", isAdmin));
        }
        return ResponseEntity.status(404).body(null);
    }
}
