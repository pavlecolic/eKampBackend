package org.unibl.etf.ekamp.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "camp")
public class CampEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "capacity", nullable = true)
    private Integer capacity;

    @OneToMany(mappedBy = "camp")
    private List<AssignmentEntity> assignments;

    @ManyToOne
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private PlaceEntity place;

    @ManyToOne
    @JoinColumn(name = "camp_status_id", referencedColumnName = "id", nullable = false)
    private CampStatusEntity campStatus;

    @OneToMany(mappedBy = "camp")
    private List<ResidencePeriodEntity> residencePeriods;
}
