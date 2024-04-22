package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.model.Employee;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.services.EmployeeService;

import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudJpaService<EmployeeEntity, Integer> implements EmployeeService {
    public EmployeeServiceImpl(EmployeeEntityRepository repository, ModelMapper modelMapper) {
        super(repository, EmployeeEntity.class, modelMapper);
    }

    @Override
    public Employee findByUsername(String username) {
        Optional<EmployeeEntity> employeeOpt = getRepository().findAll().stream().filter(u -> u.getUsername().equals(username)).findFirst();
        if (employeeOpt.isPresent()) {
            EmployeeEntity ent = employeeOpt.get();
            Employee employee = new Employee();
            employee.setUsername(ent.getUsername());
            employee.setPassword(ent.getPassword());
            employee.setIsAdmin(ent.getIsAdmin());
            return employee;
        }
        return null;
    }
}