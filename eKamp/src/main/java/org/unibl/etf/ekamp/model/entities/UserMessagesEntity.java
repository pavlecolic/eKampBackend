package org.unibl.etf.ekamp.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.base.BaseEntity;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user_messages")
public class UserMessagesEntity implements BaseEntity<UserMessagesEntityId> {

    @EmbeddedId
    UserMessagesEntityId id;

    @Column(name="read_at")
    Timestamp readAt;

    @ManyToOne
    @MapsId("messageId")
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    @JsonBackReference
    private MessageEntity message;

    @ManyToOne
    @MapsId("employeePersonId")
    @JoinColumn(name = "employee_person_id", referencedColumnName = "person_id")
    @JsonBackReference
    private EmployeeEntity employee;

}
