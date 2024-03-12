package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.sql.Date;

@Data
@Entity
@Table(name = "person")
public class PersonEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "first_name", nullable = true, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = true, length = 45)
    private String lastName;
    @Basic
    @Column(name = "date_of_birth", nullable = true)
    private Date dateOfBirth;
    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    private String sex;
    @Basic
    @Column(name = "jmbg", nullable = true, length = 13)
    private String jmbg;
//    @OneToOne(mappedBy = "person")
//    private EmployeeEntity employee;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id", nullable = false)
    private CountryEntity country;
//    @OneToOne(mappedBy = "person")
//    private ResidentEntity resident;

}