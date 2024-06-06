package org.unibl.etf.ekamp.model.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DepartureRequest {
    @NotNull
    private Integer residentId;
    @NotNull
    private Integer campId;
}
