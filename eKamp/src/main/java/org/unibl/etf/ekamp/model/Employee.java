package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.AssignmentEntity;
import org.unibl.etf.ekamp.model.entities.PersonEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;

import java.util.List;
@Data
public class Employee {


    private Integer id;
    private String password;
    private String username;
   /* private Boolean isAdmin;
    private List<AssignmentEntity> assignments;
    private PersonEntity person;
    private List<ResidentEntity> residents;*/
}
