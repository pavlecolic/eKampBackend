package org.unibl.etf.ekamp.model.requests;

import lombok.Data;

import java.sql.Date;

@Data
public class ChangeAssignmentRequest {

    private Date startDate;
    private Integer campId;
}
