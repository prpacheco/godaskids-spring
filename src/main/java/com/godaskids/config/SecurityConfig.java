package com.godaskids.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable()) // desabilita para facilitar no front
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // libera TUDO
            )
            .formLogin(login -> login.disable()) // remove tela de login
            .httpBasic(basic -> basic.disable()); // remove basic auth

        return http.build();
    }
}
