package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.CampStatusEntity;
import org.unibl.etf.ekamp.repositories.CampStatusRepository;

@Service
@Transactional
public class CampStatusService extends CrudJpaService<CampStatusEntity, Integer> implements org.unibl.etf.ekamp.services.CampStatusService {
    public CampStatusService(CampStatusRepository repository, ModelMapper modelMapper) {
        super(repository, CampStatusEntity.class, modelMapper);
    }
}
