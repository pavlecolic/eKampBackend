package org.unibl.etf.ekamp.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;
import org.unibl.etf.ekamp.services.ResidentService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/residents")
public class ResidentController extends CrudController<Integer, ResidentRequest, Resident> {
    private final ResidentService residentService;
    protected ResidentController(ResidentService residentService) {
        super(Resident.class, residentService);
        this.residentService = residentService;
    }

//    @GetMapping
//    public ResponseEntity<List<Resident>> getAll(
//            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
//            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
//    ) {
//        return new ResponseEntity<>(residentService.)
    //}

}
