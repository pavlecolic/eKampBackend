package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.MunicipalityEntity;
import org.unibl.etf.ekamp.repositories.MunicipalityEntityRepository;
import org.unibl.etf.ekamp.services.MunicipalityService;

@Service
@Transactional
public class MunicipalityServiceImpl extends CrudJpaService<MunicipalityEntity, Integer> implements MunicipalityService {
    public MunicipalityServiceImpl(MunicipalityEntityRepository repository, ModelMapper modelMapper) {
        super(repository, MunicipalityEntity.class, modelMapper);
    }
}
