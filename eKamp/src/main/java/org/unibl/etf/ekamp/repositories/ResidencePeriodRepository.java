package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unibl.etf.ekamp.model.entities.ResidencePeriodEntity;

import java.util.List;

@Repository
public interface ResidencePeriodRepository extends JpaRepository<ResidencePeriodEntity, Integer> {
    List<ResidencePeriodEntity> findByResidentId(Integer id);
    List<ResidencePeriodEntity> findByResidentIdAndCampId(Integer residentId, Integer campId);
}
