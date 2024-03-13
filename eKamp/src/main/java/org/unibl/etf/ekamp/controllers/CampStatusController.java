package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.model.CampStatus;
import org.unibl.etf.ekamp.model.CampStatusRequest;
import org.unibl.etf.ekamp.services.CampStatusService;

@RestController
@RequestMapping("/camp-statuses")
public class CampStatusController extends CrudController<Integer, CampStatusRequest, CampStatus> {
    protected CampStatusController(CampStatusService crudService) {
        super(CampStatus.class, crudService);
    }
}
