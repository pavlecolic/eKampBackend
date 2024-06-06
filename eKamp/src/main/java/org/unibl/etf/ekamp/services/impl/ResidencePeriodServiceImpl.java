package org.unibl.etf.ekamp.services.impl;

import jakarta.persistence.GeneratedValue;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.dto.ResidencePeriod;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;
import org.unibl.etf.ekamp.repositories.ResidencePeriodRepository;
import org.unibl.etf.ekamp.services.PlaceService;
import org.unibl.etf.ekamp.services.ResidencePeriodService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ResidencePeriodServiceImpl extends CrudJpaService<ResidencePeriodEntity, Integer> implements ResidencePeriodService {
    private final ResidencePeriodRepository residencePeriodRepository;
    public ResidencePeriodServiceImpl(ResidencePeriodRepository repository, ModelMapper modelMapper) {
        super(repository, ResidencePeriodEntity.class, modelMapper);
        this.residencePeriodRepository = repository;
    }

    @Override
    public List<ResidencePeriod> getResidentResidencePeriods(Integer id) {
        return residencePeriodRepository.findByResidentId(id).stream()
                .map(rpe -> getModelMapper().map(rpe, ResidencePeriod.class))
                .collect(Collectors.toList());
    }
}
