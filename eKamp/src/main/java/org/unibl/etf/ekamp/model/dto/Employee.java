package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;
import org.unibl.etf.ekamp.model.enums.AccountStatus;
import org.unibl.etf.ekamp.model.enums.Role;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Person {

    private String username;
    private Role role;
    private AccountStatus status;
     /*private List<AssignmentEntity> assignments;
    private PersonEntity person;
    private List<ResidentEntity> residents;*/
}
