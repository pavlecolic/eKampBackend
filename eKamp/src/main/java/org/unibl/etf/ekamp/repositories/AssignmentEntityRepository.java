package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;

import java.util.List;

public interface AssignmentEntityRepository  extends JpaRepository<AssignmentEntity, Integer> {
    List<AssignmentEntity> getAllByEmployeeId(Integer id);
    List<AssignmentEntity> getAllByEndDateIsNullAndCampId(Integer id);
}
