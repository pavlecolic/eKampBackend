package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.PersonEntity;

public interface EmployeeServiceRepository extends JpaRepository<PersonEntity, Integer> {

}
