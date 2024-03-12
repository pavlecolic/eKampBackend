package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employee")
@PrimaryKeyJoinColumn(name = "person_id")
public class EmployeeEntity extends PersonEntity implements BaseEntity<Integer> {

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

    @OneToMany(mappedBy = "employee")
    private List<ResidentEntity> residents;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

}
