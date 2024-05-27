package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CampEntity;
import org.unibl.etf.ekamp.model.entities.ResidentEntity;

import java.sql.Timestamp;
@Data
public class ResidencePeriod {

    private Integer id;

    private Timestamp startDate;

    private Timestamp endDate;

    private String campName;

    private String residentJmbg;
}
