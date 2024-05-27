package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.dto.Camp;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.CampEntity;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.repositories.CampEntityRepository;
import org.unibl.etf.ekamp.services.AssignmentService;
import org.unibl.etf.ekamp.services.CampService;

import java.util.Optional;

@Service
@Transactional
public class CampServiceImpl extends CrudJpaService<CampEntity, Integer> implements CampService {
    public CampServiceImpl(CampEntityRepository repository, ModelMapper modelMapper) {
        super(repository, CampEntity.class, modelMapper);
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
}
