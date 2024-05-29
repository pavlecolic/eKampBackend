package org.unibl.etf.ekamp.services;

import org.unibl.etf.ekamp.model.dto.LoginResponse;
import org.unibl.etf.ekamp.model.requests.LoginRequest;

public interface AuthService {
    LoginResponse login(LoginRequest request);

}
