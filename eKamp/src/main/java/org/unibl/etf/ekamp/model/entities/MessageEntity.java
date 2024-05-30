package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="message")
public class MessageEntity implements BaseEntity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Integer id;

    @Basic
    @Column(name="content")
    private String content;

    @Basic
    @Column(name="time_created", nullable = false)
    private LocalDateTime creationTime;

    @ManyToOne
    @JoinColumn(name = "employee_person_id", referencedColumnName = "person_id", nullable = false)
    private EmployeeEntity employee;

}
