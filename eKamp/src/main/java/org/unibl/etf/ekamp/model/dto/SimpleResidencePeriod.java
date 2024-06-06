package org.unibl.etf.ekamp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleResidencePeriod {

    private Integer campId;
    private Integer residentId;
    private Timestamp startDate;
    private Timestamp endDate;
}
