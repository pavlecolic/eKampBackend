package org.unibl.etf.ekamp.model.requests;

import lombok.Data;

import java.sql.Date;
@Data
public class AssignmentRequest {

    private Date startDate;
    private Date endDate;
    private Integer employeeId;
    private Integer campId;

}
