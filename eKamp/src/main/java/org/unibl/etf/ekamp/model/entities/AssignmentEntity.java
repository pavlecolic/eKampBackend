package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@Entity
@Table(name = "assignment")
public class AssignmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "start_date", nullable = true)
    private Date startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    @ManyToOne
    @JoinColumn(name = "employee_person_id", referencedColumnName = "Person_id", nullable = false)
    private EmployeeEntity employee;
    @ManyToOne
    @JoinColumn(name = "camp_id", referencedColumnName = "id", nullable = false)
    private CampEntity camp;

}
