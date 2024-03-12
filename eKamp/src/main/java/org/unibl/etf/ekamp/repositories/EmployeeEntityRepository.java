package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, Integer> {

}
