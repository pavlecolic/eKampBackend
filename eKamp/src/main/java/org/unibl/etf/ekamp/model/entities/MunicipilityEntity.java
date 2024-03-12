package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "municipility")
public class MunicipilityEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "post_code", nullable = true, length = 20)
    private String postCode;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private CountryEntity country;
    @OneToMany(mappedBy = "municipility")
    private List<PlaceEntity> places;

}
