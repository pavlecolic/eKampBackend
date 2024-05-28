package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;
import org.unibl.etf.ekamp.services.ResidentService;

@RestController
@CrossOrigin
@RequestMapping("/residents")
public class ResidentController extends CrudController<Integer, ResidentRequest, Resident> {
    protected ResidentController(ResidentService residentService) {
        super(Resident.class, residentService);
    }
}
