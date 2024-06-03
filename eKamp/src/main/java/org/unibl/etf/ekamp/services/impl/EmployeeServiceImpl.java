package org.unibl.etf.ekamp.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.base.CrudJpaService;
import org.unibl.etf.ekamp.exceptions.ConflictException;
import org.unibl.etf.ekamp.exceptions.ForbiddenException;
import org.unibl.etf.ekamp.model.dto.Assignment;
import org.unibl.etf.ekamp.model.dto.Employee;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.enums.AccountStatus;
import org.unibl.etf.ekamp.model.requests.*;
import org.unibl.etf.ekamp.repositories.AssignmentEntityRepository;
import org.unibl.etf.ekamp.repositories.CampEntityRepository;
import org.unibl.etf.ekamp.repositories.CountryEntityRepository;
import org.unibl.etf.ekamp.repositories.EmployeeEntityRepository;
import org.unibl.etf.ekamp.services.EmployeeService;


import org.unibl.etf.ekamp.model.enums.Role;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional
public class EmployeeServiceImpl extends CrudJpaService<EmployeeEntity, Integer> implements EmployeeService {

    private final EmployeeEntityRepository repository;
    private final CountryEntityRepository countryEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final AssignmentEntityRepository assignmentEntityRepository;
    private final CampEntityRepository campEntityRepository;



    public EmployeeServiceImpl(ModelMapper modelMapper, EmployeeEntityRepository repository, CountryEntityRepository countryEntityRepository, PasswordEncoder passwordEncoder, AssignmentEntityRepository assignmentEntityRepository, CampEntityRepository campEntityRepository){

        super(repository, EmployeeEntity.class, modelMapper);
        this.repository = repository;
        this.countryEntityRepository = countryEntityRepository;
        this.passwordEncoder = passwordEncoder;
        this.assignmentEntityRepository = assignmentEntityRepository;
        this.campEntityRepository = campEntityRepository;
    }

//    @Override
//    public Employee findByUsername(String username) {
//        Optional<EmployeeEntity> employeeOpt = getRepository().findAll().stream().filter(u -> u.getUsername().equals(username)).findFirst();
//        if (employeeOpt.isPresent()) {
//            EmployeeEntity ent = employeeOpt.get();
//            Employee employee = new Employee();
//            employee.setUsername(ent.getUsername());
//            employee.setPassword(ent.getPassword());
//            employee.setIsAdmin(ent.getIsAdmin());
//            return employee;
//        }
//        return null;
//    }

    @Override
    public Employee findByUsername(String username) throws UsernameNotFoundException {
        return getModelMapper().map(repository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username)), Employee.class);
    }

    public void create(EmployeeRequest request) {
        if(repository.existsByUsername(request.getUsername()))
            throw new ConflictException();
        EmployeeEntity entity = getModelMapper().map(request, EmployeeEntity.class);
        entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        entity.setStatus(AccountStatus.ACTIVE);
        entity.setRole(Role.VOLUNTEER);
        repository.save(entity);
    }

    @Override
    public Employee update(Integer id, EmployeeUpdateRequest user) {
        if (repository.existsByUsernameAndIdNot(user.getUsername(), id))
            throw new ConflictException();
        EmployeeEntity entity = findEntityById(id);
        entity.setUsername(user.getUsername());
        entity.setFirstName(user.getFirstName());
        entity.setLastName(user.getLastName());
        entity.setDateOfBirth(user.getDateOfBirth());
        entity.setSex(user.getSex());
        entity.setJmbg(user.getJmbg());
        entity.setCountry(countryEntityRepository.findById(user.getCountryId()).orElse(null));
        return update(id, entity, Employee.class);
    }

    @Override
    public Employee signUp(EmployeeRequest request) {
        if(repository.existsByUsername(request.getUsername()))
            throw new ConflictException();
        EmployeeEntity employeeEntity = getModelMapper().map(request, EmployeeEntity.class);
        employeeEntity.setPassword(passwordEncoder.encode(employeeEntity.getPassword()));
        employeeEntity.setStatus(AccountStatus.ACTIVE);
        employeeEntity.setRole(Role.VOLUNTEER);
        Employee employee = insert(employeeEntity, Employee.class);
        return employee;
    }

    @Override
    public Assignment changeAssignment(Integer userId, ChangeAssignmentRequest assignmentRequest) {
        EmployeeEntity entity = findEntityById(userId);
        if(entity.getRole() != Role.VOLUNTEER)
            throw new ForbiddenException();
        for(AssignmentEntity assignmentEntity : entity.getAssignments()) {
            if(assignmentEntity.getEndDate() == null) {
                assignmentEntity.setEndDate(Date.valueOf(LocalDate.now()));
            }
        }
        AssignmentRequest request = new AssignmentRequest();
        request.setEmployeeId(userId);
        request.setCampId(assignmentRequest.getCampId());
        request.setStartDate(assignmentRequest.getStartDate());
        request.setEndDate(null);
        AssignmentEntity newAssignment = getModelMapper().map(request, AssignmentEntity.class);
        assignmentEntityRepository.save(newAssignment);
        Assignment returnAssignment =  getModelMapper().map(newAssignment, Assignment.class);
        returnAssignment.setCampName(campEntityRepository.getReferenceById(assignmentRequest.getCampId()).getName());
        return returnAssignment;
    }

    @Override
    public Assignment currentAssignment(Integer id) {
        EmployeeEntity employeeEntity = findEntityById(id);
        AssignmentEntity ae = employeeEntity.getAssignments().stream().filter(a -> a.getEndDate() == null).findFirst().get();
        return getModelMapper().map(ae, Assignment.class);

    }

    @Override
    public void changeStatus(Integer userId, ChangeEmployeeStatusRequest request) {
        EmployeeEntity entity = findEntityById(userId);
        entity.setStatus(getModelMapper().map(request.getAccountStatus(), AccountStatus.class));
        repository.saveAndFlush(entity);
    }
}