package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.CampRequest;
import org.unibl.etf.ekamp.model.requests.CampStatusRequest;
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
// TODO:
//    @GetMapping("/{id}/residents")
//    public Page<Resident> getCampResidents(
//            @PathVariable Integer id,
//            @RequestParam(defaultValue = "0") int page,
//            @RequestParam(defaultValue = "10") int size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return campService.getCampResidents(id, pageable);
//    }

    @PatchMapping("/{id}/status")
    public void changeCampStatus(@PathVariable Integer id, @RequestBody CampStatusRequest campStatusRequest)  {
        campService.changeCampStatus(id, campStatusRequest);
    }

    @GetMapping("{id}/residents")
    public List<Resident> getAllCampResidents(@PathVariable Integer id) {
        return campService.getAllCampResidents(id);
    }

    @GetMapping("{id}/all-residents")
    public List<Resident> getAllCampResidentsEver(@PathVariable Integer id) {
        return campService.getAllCampResidentsEver(id);
    }
    @GetMapping("{id}/volunteers")
    public List<Employee> getAllVolunteers(@PathVariable Integer id) {
        return campService.getAllVolunteers(id);
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
