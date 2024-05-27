package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;
import org.unibl.etf.ekamp.repositories.ResidencePeriodRepository;
import org.unibl.etf.ekamp.services.PlaceService;
import org.unibl.etf.ekamp.services.ResidencePeriodService;
@Service
@Transactional
public class ResidencePeriodServiceImpl extends CrudJpaService<ResidencePeriodEntity, Integer> implements ResidencePeriodService {
    public ResidencePeriodServiceImpl(ResidencePeriodRepository repository, ModelMapper modelMapper) {
        super(repository, ResidencePeriodEntity.class, modelMapper);
    }
}
