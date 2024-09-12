package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.project.service.CustomUserDetailsSercive;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
	@Autowired
	private CustomUserDetailsSercive customUserDetailsSercive;
	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	// Cấu hình trong SecurityConfig
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http.csrf(csrf -> csrf.disable())
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/*").permitAll() 
	            .requestMatchers("/admin/**").permitAll()// Cho phép truy cập tất cả vào trang chủ
	            .requestMatchers("/admin/**").hasAnyAuthority("ADMIN") // Yêu cầu quyền ADMIN cho đường dẫn /admin/**
	            .anyRequest().authenticated())
	        .formLogin(login -> login
	            .loginPage("/login")
	            .loginProcessingUrl("/login")
	            .usernameParameter("username")
	            .passwordParameter("password")
	            .defaultSuccessUrl("/admin", true)).logout(logout->logout.logoutUrl("/admin-logout").logoutSuccessUrl("/login")).
	        	logout(logout->logout.logoutUrl("/admin-logout").logoutSuccessUrl("/login")); 
	    return http.build();
	}


	@Bean
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web)->web.ignoring().requestMatchers("/FE/**","/static/**","/assets/**","/uploads/**");
	}
	
}
