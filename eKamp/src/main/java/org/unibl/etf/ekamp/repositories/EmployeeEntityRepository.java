package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;

import java.util.Optional;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {

     Optional<EmployeeEntity> findByUsername(String username);
}
