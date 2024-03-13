package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.repositories.PlaceEntityRepository;
import org.unibl.etf.ekamp.services.PlaceService;
@Service
@Transactional
public class PlaceServiceImpl extends CrudJpaService<PlaceEntity, Integer> implements PlaceService {
    public PlaceServiceImpl(PlaceEntityRepository repository, ModelMapper modelMapper) {
        super(repository, PlaceEntity.class, modelMapper);
    }
}
