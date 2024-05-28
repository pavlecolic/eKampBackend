package org.unibl.etf.ekamp.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;

public interface JwtEmployeeDetailsService {
    JwtEmployee loadEmployeeByUsername(String username) throws UsernameNotFoundException;
}
