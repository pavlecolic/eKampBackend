package org.unibl.etf.ekamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.ekamp.model.dto.Country;
import org.unibl.etf.ekamp.model.entities.CountryEntity;

import java.util.Optional;

public interface CountryEntityRepository extends JpaRepository<CountryEntity, Integer> {

}
