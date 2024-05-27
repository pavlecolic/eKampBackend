package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.Place;
import org.unibl.etf.ekamp.model.PlaceRequest;
import org.unibl.etf.ekamp.services.PlaceService;

@RestController
@CrossOrigin
@RequestMapping("/places")
public class PlaceController extends CrudController<Integer, PlaceRequest, Place> {
    protected PlaceController(PlaceService placeService) {
        super(Place.class, placeService);
    }
}
