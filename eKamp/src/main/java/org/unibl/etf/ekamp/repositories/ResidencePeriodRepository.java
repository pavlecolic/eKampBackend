package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;

public interface ResidencePeriodRepository extends JpaRepository<ResidencePeriodEntity, Integer> {
}
