package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.Country;
import org.unibl.etf.ekamp.model.requests.CountryRequest;
import org.unibl.etf.ekamp.services.CountryService;

@RestController
@CrossOrigin
@RequestMapping("/countries")
public class CountryController extends CrudController<Integer, CountryRequest, Country> {
    protected CountryController(CountryService countryService) {
        super(Country.class, countryService);
    }
}
