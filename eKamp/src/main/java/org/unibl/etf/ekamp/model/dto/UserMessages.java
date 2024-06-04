package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.EmployeeEntity;
import org.unibl.etf.ekamp.model.entities.MessageEntity;

import java.sql.Timestamp;

@Data
public class UserMessages {
    private Timestamp readAt;
    private Message message;
}
