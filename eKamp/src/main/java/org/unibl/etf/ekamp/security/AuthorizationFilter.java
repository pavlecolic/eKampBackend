package org.unibl.etf.ekamp.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Value("${authorization.token.header.name}")
    private String authorizationHeaderName;
    @Value("${authorization.token.header.prefix}")
    private String authorizationHeaderPrefix;
    @Value("${authorization.token.secret}")
    private String authorizationSecret;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
