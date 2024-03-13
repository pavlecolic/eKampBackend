package org.unibl.etf.ekamp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;

@SpringBootApplication
public class EKampApplication {


    public static void main(String[] args) {
        SpringApplication.run(EKampApplication.class, args);
    }
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setAmbiguityIgnored(true);
        return mapper;
    }
}
