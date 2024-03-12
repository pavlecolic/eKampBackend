package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.repositories.EmployeeServiceRepository;
import org.unibl.etf.ekamp.repositories.PersonEntityRepository;
import org.unibl.etf.ekamp.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudJpaService<PersonEntity, Integer> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeServiceRepository repository, ModelMapper modelMapper) {
        super(repository, PersonEntity.class, modelMapper);
    }
}