package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "resident", schema = "ekamp", catalog = "")
public class ResidentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "person_id", nullable = false)
    private Integer personId;
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

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Boolean getNeedsHospitalisation() {
        return needsHospitalisation;
    }

    public void setNeedsHospitalisation(Boolean needsHospitalisation) {
        this.needsHospitalisation = needsHospitalisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResidentEntity that = (ResidentEntity) o;

        if (personId != null ? !personId.equals(that.personId) : that.personId != null) return false;
        if (needsHospitalisation != null ? !needsHospitalisation.equals(that.needsHospitalisation) : that.needsHospitalisation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (needsHospitalisation != null ? needsHospitalisation.hashCode() : 0);
        return result;
    }

    public List<ResidencePeriodEntity> getResidencePeriods() {
        return residencePeriods;
    }

    public void setResidencePeriods(List<ResidencePeriodEntity> residencePeriods) {
        this.residencePeriods = residencePeriods;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }
}
