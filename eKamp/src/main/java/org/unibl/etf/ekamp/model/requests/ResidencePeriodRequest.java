package org.unibl.etf.ekamp.model.requests;

import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CampEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;

import java.sql.Timestamp;
@Data
public class ResidencePeriodRequest {


    private Timestamp startDate;

    private Timestamp endDate;

    private Integer campId;

    private Integer residentId;
}
