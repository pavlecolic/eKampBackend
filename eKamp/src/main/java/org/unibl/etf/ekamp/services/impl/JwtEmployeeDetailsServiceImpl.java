package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;
import org.unibl.etf.ekamp.model.enums.AccountStatus;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.services.JwtEmployeeDetailsService;

@Service
@Transactional
public class JwtEmployeeDetailsServiceImpl implements JwtEmployeeDetailsService {

    private final EmployeeEntityRepository employeeEntityRepository;
    private final ModelMapper modelMapper;

    public JwtEmployeeDetailsServiceImpl(EmployeeEntityRepository employeeEntityRepository, ModelMapper modelMapper) {
        this.employeeEntityRepository = employeeEntityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public JwtEmployee loadUserByUsername(String username) throws UsernameNotFoundException {
        return modelMapper.map(employeeEntityRepository.findByUsernameAndStatus(username, AccountStatus.ACTIVE).orElseThrow(() -> new UsernameNotFoundException(username)), JwtEmployee.class);
    }


}
