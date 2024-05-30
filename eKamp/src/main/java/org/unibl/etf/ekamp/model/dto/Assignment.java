package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
public class Assignment {
        private Integer id;
        private Date startDate;
        private Date endDate;
        private Integer employeeId;
        private String campName;
}
