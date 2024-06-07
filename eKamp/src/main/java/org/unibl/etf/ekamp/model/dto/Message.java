package org.unibl.etf.ekamp.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
public class Message {
    private Integer id;
    private String content;
    private LocalDateTime creationTime;
    private Integer employeeId;
    private String employeeUsername;
}

