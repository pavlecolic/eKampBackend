package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.dto.CampResidencePeriod;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.requests.CampRequest;
import org.unibl.etf.ekamp.services.CampService;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/camps")
public class CampController extends CrudController<Integer, CampRequest, Camp> {

    private final CampService campService;

    protected CampController(CampService crudService) {
        super(Camp.class, crudService);
        this.campService= crudService;
    }

    @GetMapping("/{id}/residence-periods")
    public List<ResidencePeriod> campResidencePeriods(@PathVariable Integer id) {
        return campService.campResidencePeriods(id);
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
