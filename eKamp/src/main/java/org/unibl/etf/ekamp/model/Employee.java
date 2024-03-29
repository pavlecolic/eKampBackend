package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class Employee extends Person {


    private String password;
    private String username;
   /* private Boolean isAdmin;
    private List<AssignmentEntity> assignments;
    private PersonEntity person;
    private List<ResidentEntity> residents;*/
}
