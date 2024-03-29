/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.edulightbe.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

/**
 *
 * @author Le Thanh Long
 */
@Configuration
@EnableWebSecurity
public class EduLightSecurityConfiguration {
//    @Bean
//    public JwtProvider jwtProvider() {
//        return new JwtProviderImpl();
//    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("*"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }

//    @Bean
//    ZooManagementSecurityFilter zooManagementSecurityFilter() {
//        return new ZooManagementSecurityFilter();
//    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
//                .addFilterBefore(zooManagementSecurityFilter(), AuthorizationFilter.class)
                .authorizeHttpRequests(
                        requests -> requests.requestMatchers("/utils/**", "/orders/**", "/payment/**", "/auth/**","/accounts/**")
                                .permitAll()
//                                .requestMatchers(HttpMethod.GET, "/accounts/**", "/cages/**", "/animals/**")
//                                .authenticated()
//                                .requestMatchers(HttpMethod.GET, "/**")
//                                .permitAll()
//                                .requestMatchers("/tickets/**", "/areas/**", "/animal-species/**")
//                                .hasAuthority(AccountRoleEnum.ADMIN.getValue())
//                                .requestMatchers("/news/**", "/cages/**", "/animals/**", "/meals/**", "/accounts/**", "/foods/**")
//                                .hasAnyAuthority(AccountRoleEnum.ADMIN.getValue(), AccountRoleEnum.INSTRUCTOR.getValue())
//                                .requestMatchers("/meal-records/**")
//                                .authenticated()
                );
        return http.build();
    }
}
