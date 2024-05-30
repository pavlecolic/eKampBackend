package org.unibl.etf.ekamp.model.requests;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageRequest {

    private String content;
    private Integer employeeId;
    private LocalDateTime creationTime;
}
