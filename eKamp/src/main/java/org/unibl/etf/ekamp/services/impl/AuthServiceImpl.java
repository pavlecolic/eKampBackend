package org.unibl.etf.ekamp.services.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.unibl.etf.ekamp.exceptions.UnathorizedException;
import org.unibl.etf.ekamp.model.dto.JwtEmployee;
import org.unibl.etf.ekamp.model.dto.LoginResponse;
import org.unibl.etf.ekamp.model.requests.LoginRequest;
import org.unibl.etf.ekamp.services.AuthService;
import org.unibl.etf.ekamp.services.EmployeeService;
import org.unibl.etf.ekamp.util.LoggingUtil;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final EmployeeService employeeService;
    @Value("${authorization.token.expiration-time}")
    private String tokenExpirationTime;
    @Value("${authorization.token.secret}")
    private String tokenSecret;


    public AuthServiceImpl(AuthenticationManager authenticationManager, EmployeeService employeeService) {
        this.authenticationManager = authenticationManager;
        this.employeeService = employeeService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        LoginResponse response;
        try {
            Authentication authentication = authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    request.getUsername(), request.getPassword()
                            )
                    );
            JwtEmployee employee = (JwtEmployee) authentication.getPrincipal();
            response = employeeService.findById(employee.getId(), LoginResponse.class);
            response.setToken(generateJwt(employee));
        } catch (Exception ex) {
            LoggingUtil.logException(ex, getClass());
            throw new UnathorizedException();
        }
        return response;
    }

    private String generateJwt(JwtEmployee user) {
        return Jwts.builder()
                .id(user.getId().toString())
                .claim("role", user.getRole().name())
                .subject(user.getId().toString())
                .expiration(new Date(System.currentTimeMillis() + Long.parseLong(tokenExpirationTime)))
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(tokenSecret)))
                .compact();
    }
}
