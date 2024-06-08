package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.exceptions.NotFoundException;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.enums.AccountStatus;

import java.util.Optional;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {
     Optional<EmployeeEntity> findByUsername(String username);
     Optional<EmployeeEntity> findByUsernameAndStatus(String username, AccountStatus status);
     Boolean existsByUsernameAndIdNot(String username, Integer id);
     Boolean existsByUsername(String username);
     default AssignmentEntity getCurrentAssignment(Integer id) {
           return findById(id).get().getAssignments().stream().filter(a -> a.getEndDate() == null).findFirst().orElseThrow(NotFoundException::new);
     }


}
