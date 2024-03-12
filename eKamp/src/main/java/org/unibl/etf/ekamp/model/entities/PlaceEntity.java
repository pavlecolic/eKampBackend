package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "place", schema = "ekamp", catalog = "")
public class PlaceEntity {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlaceEntity that = (PlaceEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    public List<CampEntity> getCamps() {
        return camps;
    }

    public void setCamps(List<CampEntity> camps) {
        this.camps = camps;
    }

    public MunicipilityEntity getMunicipility() {
        return municipility;
    }

    public void setMunicipility(MunicipilityEntity municipility) {
        this.municipility = municipility;
    }
}
