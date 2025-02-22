package com.baghel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .sessionManagement()
                .invalidSessionUrl("/sessionExpired")  // Redirect to this URL if session is invalid
                .maximumSessions(1)  // Maximum number of concurrent sessions per user
                .expiredUrl("/sessionExpired")  // Redirect to this URL when session expires
                .and()
            .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);  // Optional: Define session creation policy

        // Configure session timeout (in seconds)
        http.sessionManagement()
            .sessionFixation().none() // Optional: you can add other session strategies
            .maximumSessions(1)
            .expiredUrl("/sessionExpired");

    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}
