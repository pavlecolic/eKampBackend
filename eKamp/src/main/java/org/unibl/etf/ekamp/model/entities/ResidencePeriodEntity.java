package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "residence_period", schema = "ekamp", catalog = "")
public class ResidencePeriodEntity {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidencePeriodEntity that = (ResidencePeriodEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        return result;
    }

    public CampEntity getCamp() {
        return camp;
    }

    public void setCamp(CampEntity camp) {
        this.camp = camp;
    }

    public ResidentEntity getResident() {
        return resident;
    }

    public void setResident(ResidentEntity resident) {
        this.resident = resident;
    }
}
