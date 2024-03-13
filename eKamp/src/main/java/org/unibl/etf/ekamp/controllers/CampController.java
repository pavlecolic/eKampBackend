package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.Assignment;
import org.unibl.etf.ekamp.model.AssignmentRequest;
import org.unibl.etf.ekamp.model.Camp;
import org.unibl.etf.ekamp.model.CampRequest;
import org.unibl.etf.ekamp.services.CampService;

@RestController
@RequestMapping("/camps")
public class CampController extends CrudController<Integer, CampRequest, Camp> {
    protected CampController(CampService crudService) {
        super(Camp.class, crudService);
    }
}
