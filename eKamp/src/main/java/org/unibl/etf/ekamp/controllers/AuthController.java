package org.unibl.etf.ekamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.entities.CountryEntity;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.model.requests.EmployeeRequest;
import org.unibl.etf.ekamp.model.requests.RegisterRequest;
import org.unibl.etf.ekamp.services.CountryService;
import org.unibl.etf.ekamp.services.EmployeeService;

import java.util.Map;

@CrossOrigin
@RestController
public class AuthController {

    private final EmployeeService employeeService;
    private final CountryService countryService;

    public AuthController(EmployeeService employeeService, CountryService countryService) {
        this.employeeService = employeeService;
        this.countryService = countryService;
    }

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

    /*
    *
    *
    * PORAVITI kad se dodaje u bazu, doda se samo zaposleni, korisnuku fale podaci
    *
    *
    *
    * */
    @PostMapping("/employees/register")
    public ResponseEntity<?> createPersonAndEmployee(@RequestBody RegisterRequest request) {
        try {
            // Create a new EmployeeEntity
            EmployeeEntity employee = new EmployeeEntity();
            employee.setFirstName(request.getFirstName());
            employee.setLastName(request.getLastName());
            employee.setDateOfBirth(request.getDateOfBirth());
            employee.setSex(request.getSex());
            employee.setJmbg(request.getJmbg());

            // Retrieve the CountryEntity from the database based on the provided country ID
            CountryEntity country = countryService.findById(Integer.parseInt(request.getCountry_id()), CountryEntity.class);
            if (country == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Country not found");
            }

            // Set the CountryEntity for the EmployeeEntity
            employee.setCountry(country);

            // Set other properties for the EmployeeEntity
            employee.setUsername(request.getUsername());
            employee.setPassword(request.getPassword());
            employee.setIsAdmin(false);

            // Save the EmployeeEntity
            employeeService.insert(employee,EmployeeRequest.class);

            // Return a success response
            return ResponseEntity.ok("Employee created successfully");
        } catch (Exception e) {
            // Handle any exceptions and return an error response
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating employee");
        }
    }


}
