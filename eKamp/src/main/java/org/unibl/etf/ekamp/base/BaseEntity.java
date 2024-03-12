package org.unibl.etf.ekamp.base;

import java.io.Serializable;

public interface BaseEntity<ID extends Serializable> {
    void setId(ID id);
    ID getId();
}
