package org.unibl.etf.ekamp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.unibl.etf.ekamp.services.JwtEmployeeDetailsService;
import org.unibl.etf.ekamp.security.AuthorizationFilter;
@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    private final AuthorizationFilter authorizationFilter;
    private final JwtEmployeeDetailsService jwtEmployeeDetailsService;

    public WebSecurityConfig(AuthorizationFilter authorizationFilter, JwtEmployeeDetailsService jwtEmployeeDetailsService) {
        this.authorizationFilter = authorizationFilter;
        this.jwtEmployeeDetailsService = jwtEmployeeDetailsService;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
