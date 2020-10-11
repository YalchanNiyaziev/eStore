package com.yalco.estore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectBeanConfig {

@Bean
public ModelMapper modelMapper(){
    return new ModelMapper();
}
}
