package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.base.CrudService;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;
import org.unibl.etf.ekamp.repositories.ResidentEntityRepository;
import org.unibl.etf.ekamp.services.ResidentService;

import java.util.List;

@Service
@Transactional
public class ResidentServiceImpl extends CrudJpaService<ResidentEntity, Integer> implements ResidentService {

    public ResidentServiceImpl(ResidentEntityRepository repository, ModelMapper modelMapper) {
        super(repository, ResidentEntity.class, modelMapper);
    }
}
