package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.PlaceEntity;

public interface PlaceEntityRepository  extends JpaRepository<PlaceEntity, Integer> {
}
