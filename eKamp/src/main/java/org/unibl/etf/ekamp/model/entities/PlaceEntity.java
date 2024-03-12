package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "place")
public class PlaceEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "description", nullable = true, length = 200)
    private String description;
    @OneToMany(mappedBy = "place")
    private List<CampEntity> camps;
    @ManyToOne
    @JoinColumn(name = "municipility_id", referencedColumnName = "id", nullable = false)
    private MunicipilityEntity municipility;

}
