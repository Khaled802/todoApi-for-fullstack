package com.example.todo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

// @Configuration
public class SecurityConfiguration {


    @Bean
    SecurityFilterChain getSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests((auth)-> auth.anyRequest().authenticated())
            .httpBasic(Customizer.withDefaults())
            .csrf((csrfCustomizer)-> csrfCustomizer.disable())
            .build();
    }
    
}
