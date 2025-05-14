package com.coffeebank.gateway_service.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig {
	
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeExchange(auth -> auth
              .anyExchange().permitAll()
          );

        return http.build();
    }
}
