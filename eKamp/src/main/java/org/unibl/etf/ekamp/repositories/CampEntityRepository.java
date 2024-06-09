package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unibl.etf.ekamp.model.entities.CampEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;

import java.util.List;

public interface CampEntityRepository extends JpaRepository<CampEntity, Integer> {

    @Query("SELECT DISTINCT r FROM ResidencePeriodEntity rp JOIN rp.resident r WHERE rp.camp.id = :id AND rp.endDate IS NULL")
    List<ResidentEntity> findResidentsWithNullEndDate(@Param("id") Integer id);

    @Query("SELECT DISTINCT r FROM ResidencePeriodEntity rp JOIN rp.resident r WHERE rp.camp.id = :id")
    List<ResidentEntity> findResidentsToEverStayInCampWithId(@Param("id") Integer id);
}
