package com.acompletenoobsmoke.leetcodetrackerbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    private final static List<String> apiList;

    static {
        apiList = new ArrayList<>();
        apiList.add("/myAccount");
        apiList.add("/myBalance");
        apiList.add("/myCard");
        apiList.add("/myLoan");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JWTAuthenticationFilter jWTAuthenticationFilter) throws Exception {
        http
                .headers(headers ->
                        headers.xssProtection(withDefaults())
                                .contentSecurityPolicy(csp -> csp.policyDirectives("default-src 'self'"))
                                .frameOptions((HeadersConfigurer.FrameOptionsConfig::sameOrigin)))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/auth/**", "/h2-console/**").permitAll()
                        .requestMatchers("api/v1/users/**").authenticated()
                )
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jWTAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
