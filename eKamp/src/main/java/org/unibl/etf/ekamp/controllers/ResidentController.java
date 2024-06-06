package org.unibl.etf.ekamp.controllers;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;
import org.unibl.etf.ekamp.services.ResidentService;


@RestController
@CrossOrigin
@RequestMapping("/residents")
public class ResidentController extends CrudController<Integer, ResidentRequest, Resident> {
    private final ResidentService residentService;
    protected ResidentController(ResidentService residentService) {
        super(Resident.class, residentService);
        this.residentService = residentService;
    }
    @PatchMapping("depart")
    public void depart(@Valid @RequestBody DepartureRequest request) {
        residentService.depart(request);
    }

//    @GetMapping
//    public ResponseEntity<List<Resident>> getAll(
//            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
//            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
//    ) {
//        return new ResponseEntity<>(residentService.)
    //}

}
