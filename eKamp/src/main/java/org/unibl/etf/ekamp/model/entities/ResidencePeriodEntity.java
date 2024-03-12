package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "residence_period")
public class ResidencePeriodEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;
    @Basic
    @Column(name = "end_date", nullable = true)
    private Timestamp endDate;
    @ManyToOne
    @JoinColumn(name = "camp_id", referencedColumnName = "id", nullable = false)
    private CampEntity camp;
    @ManyToOne
    @JoinColumn(name = "resident_person_id", referencedColumnName = "person_id", nullable = false)
    private ResidentEntity resident;

}
