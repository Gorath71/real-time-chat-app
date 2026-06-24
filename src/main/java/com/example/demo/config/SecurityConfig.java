package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> auth
						.requestMatchers("/auth/**").permitAll()
						.anyRequest().authenticated())
				.formLogin(form -> form
						.loginProcessingUrl("/auth/login")
						.successHandler((req, res, auth) -> {
							res.setStatus(200);
						})
						.failureHandler((req, res, ex) -> {
							res.setStatus(401);
						}))
				.logout(logout -> logout
						.logoutUrl("/auth/logout"))
				.exceptionHandling(ex -> ex
						.authenticationEntryPoint((req, res, e) -> {
					        res.setStatus(401);
					    })
					)
				.build();
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
