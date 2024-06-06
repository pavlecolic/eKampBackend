package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;

import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.requests.ResidencePeriodRequest;
import org.unibl.etf.ekamp.services.ResidencePeriodService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/residence-periods")
public class ResidencePeriodController extends CrudController<Integer, ResidencePeriodRequest, ResidencePeriod> {
    ResidencePeriodService crudService;
    protected ResidencePeriodController( ResidencePeriodService crudService) {
        super(ResidencePeriod.class, crudService);
        this.crudService = crudService;
    }

    @GetMapping("resident/{id}")
    public List<ResidencePeriod> getResidentResidencePeriods(@PathVariable Integer id) {
        return crudService.getResidentResidencePeriods(id);
    }


}
