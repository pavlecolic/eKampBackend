package org.unibl.etf.ekamp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ekamp.base.CrudController;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.Person;
import org.unibl.etf.ekamp.model.PersonRequest;
import org.unibl.etf.ekamp.services.PersonService;

@RestController
@RequestMapping("/users")
public class PersonController extends CrudController<Integer, PersonRequest, Person> {

    protected PersonController(PersonService crudService) {
        super(Person.class, crudService);
    }
}
