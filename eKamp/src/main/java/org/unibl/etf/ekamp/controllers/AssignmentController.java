package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;

import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.requests.AssignmentRequest;
import org.unibl.etf.ekamp.services.AssignmentService;
import org.unibl.etf.ekamp.services.CampStatusService;

@RestController
@CrossOrigin
@RequestMapping("/assignments")
public class AssignmentController extends CrudController<Integer, AssignmentRequest, Assignment> {
    protected AssignmentController(AssignmentService crudService) {
        super(Assignment.class, crudService);
    }
}
