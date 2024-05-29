package org.unibl.etf.ekamp.model.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class Message {
    private Integer id;
    private String data;
    private LocalDateTime creationTime;
    private String employeeUsername;
}

