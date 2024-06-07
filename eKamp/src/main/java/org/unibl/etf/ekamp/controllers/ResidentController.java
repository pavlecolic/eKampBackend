package org.unibl.etf.ekamp.controllers;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.exceptions.NotFoundException;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;
import org.unibl.etf.ekamp.services.ResidentService;


@RestController
@CrossOrigin
@RequestMapping("/residents")
public class ResidentController {
    private final ResidentService residentService;
    protected ResidentController(ResidentService residentService) {
        this.residentService = residentService;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Resident insert(@RequestBody ResidentRequest request) throws NotFoundException {
        return residentService.addResident(request);
    }
    @PatchMapping("depart")
    public void depart(@Valid @RequestBody DepartureRequest request) {
        residentService.depart(request);
    }

    @GetMapping
    public Page<Resident> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return residentService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Resident findById(@PathVariable Integer id) throws NotFoundException {
        return residentService.findById(id, Resident.class);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) { residentService.delete(id);}

    @PutMapping("/{id}")
    public Resident update(@PathVariable Integer id, @RequestBody ResidentRequest object) throws NotFoundException {
        return residentService.update(id, object, Resident.class);
    }

//    @GetMapping
//    public ResponseEntity<List<Resident>> getAll(
//            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
//            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
//    ) {
//        return new ResponseEntity<>(residentService.)
    //}

}
