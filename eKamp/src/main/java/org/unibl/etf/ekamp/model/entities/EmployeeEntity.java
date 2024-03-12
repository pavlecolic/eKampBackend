package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity implements BaseEntity<Integer> {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "Person_id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 64)
    private String password;
    @Basic
    @Column(name = "is_admin", nullable = false)
    private Boolean isAdmin;
    @OneToMany(mappedBy = "employee")
    private List<AssignmentEntity> assignments;
    @OneToOne
    @JoinColumn(name = "Person_id", referencedColumnName = "id", nullable = false)
    private PersonEntity person;
    @OneToMany(mappedBy = "employee")
    private List<ResidentEntity> residents;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
