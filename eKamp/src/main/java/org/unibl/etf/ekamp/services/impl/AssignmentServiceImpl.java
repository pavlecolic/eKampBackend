package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.repositories.AssignmentEntityRepository;
import org.unibl.etf.ekamp.services.AssignmentService;
import org.unibl.etf.ekamp.services.CountryService;
@Service
@Transactional
public class AssignmentServiceImpl extends CrudJpaService<AssignmentEntity, Integer> implements AssignmentService {
    public AssignmentServiceImpl(AssignmentEntityRepository repository, ModelMapper modelMapper) {
        super(repository, AssignmentEntity.class, modelMapper);
    }
}

