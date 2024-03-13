package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.entities.MunicipalityEntity;

public interface MunicipalityEntityRepository extends JpaRepository<MunicipalityEntity, Integer> {
}
