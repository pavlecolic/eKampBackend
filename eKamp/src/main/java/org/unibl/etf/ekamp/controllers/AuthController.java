package org.unibl.etf.ekamp.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;
import org.unibl.etf.ekamp.model.dto.LoginResponse;
import org.unibl.etf.ekamp.model.entities.CountryEntity;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.model.requests.EmployeeRequest;
import org.unibl.etf.ekamp.model.requests.LoginRequest;
import org.unibl.etf.ekamp.model.requests.RegisterRequest;
import org.unibl.etf.ekamp.services.AuthService;
import org.unibl.etf.ekamp.services.CountryService;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.model.enums.Role;

import java.util.Map;

@CrossOrigin
@RestController
public class AuthController {

    private final EmployeeService employeeService;
    private final AuthService authService;


    public AuthController(EmployeeService employeeService, AuthService authService) {
        this.employeeService  = employeeService;
        this.authService = authService;
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @GetMapping("state")
    public LoginResponse state(Authentication auth) {
        JwtEmployee jwtUser = (JwtEmployee) auth.getPrincipal();
        return employeeService.findById(jwtUser.getId(), LoginResponse.class);
    }
}
