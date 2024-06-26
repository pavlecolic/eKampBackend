package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.dto.CampStatus;
import org.unibl.etf.ekamp.model.requests.CampStatusRequest;
import org.unibl.etf.ekamp.services.CampStatusService;

@RestController
@CrossOrigin
@RequestMapping("/camp-statuses")
public class CampStatusController extends CrudController<Integer, CampStatusRequest, CampStatus> {
    protected CampStatusController(CampStatusService crudService) {
        super(CampStatus.class, crudService);
    }
}
