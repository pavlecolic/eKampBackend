package org.unibl.etf.ekamp.model.requests;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import org.unibl.etf.ekamp.model.enums.AccountStatus;

@Data
public class ChangeEmployeeStatusRequest {
    @NotNull
    private AccountStatus accountStatus;
}
