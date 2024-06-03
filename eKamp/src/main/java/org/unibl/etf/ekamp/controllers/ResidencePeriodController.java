package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;

import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.requests.ResidencePeriodRequest;
import org.unibl.etf.ekamp.services.ResidencePeriodService;

@RestController
@CrossOrigin
@RequestMapping("/residence-periods")
public class ResidencePeriodController extends CrudController<Integer, ResidencePeriodRequest, ResidencePeriod> {
    protected ResidencePeriodController( ResidencePeriodService crudService) {
        super(ResidencePeriod.class, crudService);
    }


}
