package com.lawlayui.coffe_shop.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import com.lawlayui.coffe_shop.infrastructure.services.CustomOidcUserService;

@Configuration 
@EnableWebSecurity 
public class SecurityConfig {
    private CustomOidcUserService customOidcUserService;

    public SecurityConfig(CustomOidcUserService customOidcUserService) {
        this.customOidcUserService = customOidcUserService;
    }

    @Bean 
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http   
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/login").permitAll()
                .anyRequest().authenticated()
            )

            .oauth2Login(oauth2 -> oauth2 
                .userInfoEndpoint(userinfo -> 
                    userinfo.oidcUserService(customOidcUserService)
                )
            );

        return http.build();
    }
}
