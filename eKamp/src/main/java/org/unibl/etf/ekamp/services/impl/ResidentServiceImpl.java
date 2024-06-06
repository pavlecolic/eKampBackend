package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;
import org.unibl.etf.ekamp.repositories.ResidencePeriodRepository;
import org.unibl.etf.ekamp.repositories.ResidentEntityRepository;
import org.unibl.etf.ekamp.services.ResidentService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ResidentServiceImpl extends CrudJpaService<ResidentEntity, Integer> implements ResidentService {

    private final ResidencePeriodRepository residencePeriodRepository;

    public ResidentServiceImpl(ResidentEntityRepository repository, ModelMapper modelMapper, ResidencePeriodRepository residencePeriodRepository) {
        super(repository, ResidentEntity.class, modelMapper);
        this.residencePeriodRepository = residencePeriodRepository;
    }

    public void depart(DepartureRequest request) {
        List<ResidencePeriodEntity> residencePeriodEntityList = residencePeriodRepository.findByResidentIdAndCampId(request.getResidentId(), request.getCampId());
        residencePeriodEntityList.stream()
                .filter(rp -> rp.getEndDate() == null)
                .forEach(rp -> rp.setEndDate(Timestamp.from(Instant.now())));
    }
}
