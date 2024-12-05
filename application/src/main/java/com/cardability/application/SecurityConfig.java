package com.cardability.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       http.authorizeHttpRequests((auth)->auth.anyRequest().authenticated()).formLogin(withDefaults()).logout(withDefaults());

       http.formLogin(form->form.loginPage("login").defaultSuccessUrl("/home",true));
       return http.build();
    }
}
