package org.unibl.etf.ekamp.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMessagesEntityId implements Serializable {
    @Column(name = "message_id")
    private Integer messageId;
    @Column(name = "employee_person_id")
    private Integer employeePersonId;
}
