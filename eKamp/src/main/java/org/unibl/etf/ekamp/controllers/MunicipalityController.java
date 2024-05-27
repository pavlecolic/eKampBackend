package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Municipality;
import org.unibl.etf.ekamp.model.requests.MunicipalityRequest;
import org.unibl.etf.ekamp.services.MunicipalityService;

@RestController
@CrossOrigin
@RequestMapping("/municipalities")
public class MunicipalityController extends CrudController<Integer, MunicipalityRequest, Municipality> {
    protected MunicipalityController(MunicipalityService municipalityService) {
        super(Municipality.class, municipalityService);
    }
}
