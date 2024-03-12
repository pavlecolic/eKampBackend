package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.Person;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.repositories.PersonEntityRepository;
import org.unibl.etf.ekamp.services.PersonService;

@Service
@Transactional
public class PersonServiceImpl extends CrudJpaService<PersonEntity, Integer> implements PersonService {
    public PersonServiceImpl(PersonEntityRepository repository, ModelMapper modelMapper) {
        super(repository, PersonEntity.class, modelMapper);
    }
}
