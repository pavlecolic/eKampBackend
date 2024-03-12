package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "resident")
@PrimaryKeyJoinColumn(name = "person_id")
public class ResidentEntity extends PersonEntity implements BaseEntity<Integer> {
    @Basic
    @Column(name = "needs_hospitalisation", nullable = true)
    private Boolean needsHospitalisation;
    @OneToMany(mappedBy = "resident")
    private List<ResidencePeriodEntity> residencePeriods;
    @ManyToOne
    @JoinColumn(name = "employee_person_id", referencedColumnName = "person_id", nullable = false)
    private EmployeeEntity employee;

}
