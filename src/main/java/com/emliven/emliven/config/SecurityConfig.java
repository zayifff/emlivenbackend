package com.emliven.emliven.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/**").permitAll()  // Permit all requests
                    .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable());  // Disable CSRF protection for simplicity

        return http.build();
    }
}
