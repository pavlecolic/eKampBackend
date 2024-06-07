package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.*;
import org.unibl.etf.ekamp.base.BaseEntity;

import org.unibl.etf.ekamp.model.enums.Role;
import org.unibl.etf.ekamp.model.enums.AccountStatus;
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

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "is_admin", nullable = false)
    private Role role;

    @Enumerated(EnumType.ORDINAL)
    @Column(name="is_active", nullable = false)
    private AccountStatus status;

    @OneToMany(mappedBy = "employee")
    private List<AssignmentEntity> assignments;

    @OneToMany(mappedBy = "employee")
    private List<ResidentEntity> residents;

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<MessageEntity> messages;



}
