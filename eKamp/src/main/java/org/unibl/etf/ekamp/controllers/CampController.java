package org.unibl.etf.ekamp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.*;
import org.unibl.etf.ekamp.services.CampService;
import org.unibl.etf.ekamp.services.EmployeeService;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/camps")
public class CampController extends CrudController<Integer, CampRequest, Camp> {

    private final CampService campService;

    protected CampController(CampService crudService) {
        super(Camp.class, crudService);
        this.campService= crudService;
    }



    /*@CrossOrigin
    @GetMapping("/{name}") // Define the path variable in the URL
    public ResponseEntity getCampWithName(@PathVariable String name) {

        Camp camp = campService.findByName(name);
        if (camp != null ){

            return ResponseEntity.ok().body(camp);
        }
        return ResponseEntity.status(404).body(null);
    }*/

}
