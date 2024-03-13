package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.CampEntity;
import org.unibl.etf.ekamp.repositories.CampEntityRepository;
import org.unibl.etf.ekamp.services.AssignmentService;
import org.unibl.etf.ekamp.services.CampService;

@Service
@Transactional
public class CampServiceImpl extends CrudJpaService<CampEntity, Integer> implements CampService {
    public CampServiceImpl(CampEntityRepository repository, ModelMapper modelMapper) {
        super(repository, CampEntity.class, modelMapper);
    }
}
