package org.unibl.etf.ekamp.model.dto;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Data;
import org.unibl.etf.ekamp.model.entities.CampEntity;

import java.util.List;

@Data
public class CampStatus {
    private Integer id;
    private String name;

}
