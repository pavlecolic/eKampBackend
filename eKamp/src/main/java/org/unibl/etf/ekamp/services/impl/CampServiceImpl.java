package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.dto.*;
import org.unibl.etf.ekamp.model.entities.*;
import org.unibl.etf.ekamp.model.requests.CampStatusRequest;
import org.unibl.etf.ekamp.repositories.AssignmentEntityRepository;
import org.unibl.etf.ekamp.repositories.CampEntityRepository;
import org.unibl.etf.ekamp.repositories.CampStatusRepository;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.services.CampService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CampServiceImpl extends CrudJpaService<CampEntity, Integer> implements CampService {
    private final CampEntityRepository campEntityRepository;
    private final CampStatusRepository campStatusEntityRepository;
    private final AssignmentEntityRepository assignmentEntityRepository;
    private final EmployeeEntityRepository employeeEntityRepo;
    public CampServiceImpl(CampEntityRepository repository, ModelMapper modelMapper, CampStatusRepository campStatusEntityRepository, AssignmentEntityRepository assignmentEntityRepository, EmployeeEntityRepository employeeEntityRepo) {
        super(repository, CampEntity.class, modelMapper);
        this.campEntityRepository = repository;
        this.campStatusEntityRepository = campStatusEntityRepository;
        this.assignmentEntityRepository = assignmentEntityRepository;
        this.employeeEntityRepo = employeeEntityRepo;
    }

    @Override
    public Camp findByName(String name) {
        Optional<CampEntity> campEntity = getRepository().findAll().stream().filter(camp ->name.equals(camp.getName())).findFirst();

        if (campEntity.isPresent()) {
            CampEntity ent = campEntity.get();
            Camp camp = new Camp();
            camp.setCampStatusName(String.valueOf(ent.getCampStatus()));
            camp.setName(ent.getName());
            camp.setCapacity(ent.getCapacity());
            camp.setPlaceDescription(ent.getPlace().getDescription());

            return camp;
        }
        return null;
    }

    @Override
    public List<ResidencePeriod> campResidencePeriods(Integer id) {
        CampEntity campEntity = getRepository().getReferenceById(id);
        List<ResidencePeriodEntity> residencePeriodEntities = campEntity.getResidencePeriods();
        List<ResidencePeriod> residencePeriods = new ArrayList<>();
        for(ResidencePeriodEntity residencePeriodEntity : residencePeriodEntities) {
            residencePeriods.add(getModelMapper().map(residencePeriodEntity, ResidencePeriod.class));
        }
        return residencePeriods;
    }

    @Override
    public List<Resident> getAllCampResidents(Integer id) {
        List<ResidentEntity> residentEntities = campEntityRepository.findResidentsWithNullEndDate(id);
        List<Resident> residents = new ArrayList<>();
        for(ResidentEntity residentEntity : residentEntities) {
            residents.add(getModelMapper().map(residentEntity, Resident.class));
        }
        return residents;


    }

    @Override
    public List<Resident> getAllCampResidentsEver(Integer id) {
        List<ResidentEntity> residentEntities = campEntityRepository.findResidentsToEverStayInCampWithId(id);
        List<Resident> residents = new ArrayList<>();
        for(ResidentEntity residentEntity : residentEntities) {
            residents.add(getModelMapper().map(residentEntity, Resident.class));
        }
        return residents;
    }

    @Override
    public void changeCampStatus(Integer id, CampStatusRequest request) {
        CampEntity entity = findEntityById(id);
        CampStatusEntity campStatusEntity = campStatusEntityRepository.findCampStatusEntityByName(request.getName());
        entity.setCampStatus(campStatusEntity);
        campEntityRepository.saveAndFlush(entity);
    }

    @Override
    public List<Employee> getAllVolunteers(Integer id) {
        List<AssignmentEntity> allByEndDateIsNullAndCampId = assignmentEntityRepository.getAllByEndDateIsNullAndCampId(id);
        List<Employee> response = new ArrayList<>();
        for(AssignmentEntity assignmentEntity : allByEndDateIsNullAndCampId) {
            EmployeeEntity employeeEntity = employeeEntityRepo.getReferenceById(assignmentEntity.getEmployee().getId());
            response.add(getModelMapper().map(employeeEntity, Employee.class));
        }
        return response;
    }
}
