package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.exceptions.ForbiddenException;
import org.unibl.etf.ekamp.model.dto.Resident;
import org.unibl.etf.ekamp.model.dto.SimpleResidencePeriod;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;
import org.unibl.etf.ekamp.model.requests.DepartureRequest;
import org.unibl.etf.ekamp.model.requests.ResidentRequest;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.repositories.ResidencePeriodRepository;
import org.unibl.etf.ekamp.repositories.ResidentEntityRepository;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.services.ResidencePeriodService;
import org.unibl.etf.ekamp.services.ResidentService;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class ResidentServiceImpl extends CrudJpaService<ResidentEntity, Integer> implements ResidentService {

    private final ResidencePeriodRepository residencePeriodRepository;
    private final EmployeeEntityRepository employeeEntityRepository;
    private final ResidencePeriodService residencePeriodService;
    private final EmployeeService employeeService;
    public ResidentServiceImpl(ResidentEntityRepository repository, ModelMapper modelMapper, ResidencePeriodRepository residencePeriodRepository, EmployeeEntityRepository employeeEntityRepository, ResidencePeriodService residencePeriodService, EmployeeService employeeService) {
        super(repository, ResidentEntity.class, modelMapper);
        this.residencePeriodRepository = residencePeriodRepository;
        this.employeeEntityRepository = employeeEntityRepository;
        this.residencePeriodService = residencePeriodService;
        this.employeeService = employeeService;
    }

    @Override
    public void depart(DepartureRequest request) {
        List<ResidencePeriodEntity> residencePeriodEntityList = residencePeriodRepository.findByResidentIdAndCampId(request.getResidentId(), request.getCampId());
        residencePeriodEntityList.stream()
                .filter(rp -> rp.getEndDate() == null)
                .forEach(rp -> rp.setEndDate(Timestamp.from(Instant.now())));
    }

    @Override
    public Resident addResident(ResidentRequest request) {
        ResidentEntity entity = getModelMapper().map(request, ResidentEntity.class);
        entity.setId(null);
        AssignmentEntity assignmentEntity = employeeEntityRepository.getCurrentAssignment(request.getEmployeeId());
        if(assignmentEntity == null || !"AKTIVAN".equalsIgnoreCase(assignmentEntity.getCamp().getCampStatus().getName())) {
            throw new ForbiddenException();
        }
        SimpleResidencePeriod simpleResidencePeriod = new SimpleResidencePeriod();
        simpleResidencePeriod.setCampId(assignmentEntity.getCamp().getId());
        simpleResidencePeriod.setStartDate(Timestamp.from(Instant.now()));
        simpleResidencePeriod.setEndDate(null);

        entity = getRepository().saveAndFlush(entity);
        getEntityManager().refresh(entity);
        simpleResidencePeriod.setResidentId(entity.getId());
        SimpleResidencePeriod srp = residencePeriodService.insert(getModelMapper().map(simpleResidencePeriod, ResidencePeriodEntity.class), SimpleResidencePeriod.class);
        return getModelMapper().map(entity, Resident.class);
    }

    @Override
    public Page<Resident> findAll(Pageable pageable) {
        return findAll(pageable, Resident.class);
    }
}
