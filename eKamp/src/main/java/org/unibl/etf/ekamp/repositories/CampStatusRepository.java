package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.CampStatusEntity;

public interface CampStatusRepository extends JpaRepository<CampStatusEntity, Integer> {
}
