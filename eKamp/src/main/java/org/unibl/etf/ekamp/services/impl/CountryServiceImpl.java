package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.entities.CountryEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.repositories.CountryEntityRepository;
import org.unibl.etf.ekamp.services.CountryService;
import org.unibl.etf.ekamp.services.PersonService;

@Service
@Transactional
public class CountryServiceImpl  extends CrudJpaService<CountryEntity, Integer> implements CountryService {
    public CountryServiceImpl(CountryEntityRepository repository, ModelMapper modelMapper) {
        super(repository,CountryEntity.class, modelMapper);
    }
}
