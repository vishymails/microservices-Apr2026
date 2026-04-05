package com.bvr;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Bean 
	public SecurityFilterChain seurityFilterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(auth -> {
					auth.requestMatchers("/").permitAll();
					auth.requestMatchers("/favicon.ico").permitAll();
					auth.anyRequest().authenticated();
					
				})
				.oauth2Login(Customizer.withDefaults())
				.formLogin(Customizer.withDefaults())
				.build();
	}

}
