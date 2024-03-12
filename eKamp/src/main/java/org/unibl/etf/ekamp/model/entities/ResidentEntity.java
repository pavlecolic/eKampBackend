package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "resident")
public class ResidentEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "needs_hospitalisation", nullable = true)
    private Boolean needsHospitalisation;
    @OneToMany(mappedBy = "resident")
    private List<ResidencePeriodEntity> residencePeriods;
    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    private PersonEntity person;
    @ManyToOne
    @JoinColumn(name = "employee_person_id", referencedColumnName = "Person_id", nullable = false)
    private EmployeeEntity employee;

}
