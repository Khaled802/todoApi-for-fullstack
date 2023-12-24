package com.example.todo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    

    @Bean
    ModelMapper creatModelMapper() {
        return new ModelMapper();
    }
}