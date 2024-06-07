package org.unibl.etf.ekamp.model.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MessageRequest {
    @NotBlank
    private String content;
    @NotNull
    private Integer employeeId;

    private LocalDateTime creationTime;
}
