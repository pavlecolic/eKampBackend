package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.services.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudJpaService<EmployeeEntity, Integer> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeEntityRepository repository, ModelMapper modelMapper) {
        super(repository, EmployeeEntity.class, modelMapper);
    }
}