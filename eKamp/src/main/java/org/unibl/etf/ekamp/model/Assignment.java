package org.unibl.etf.ekamp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
@Data
public class Assignment {
        private Integer id;
        private Date startDate;
        private Date endDate;
        private String employeeName;
        private String campName;

}
