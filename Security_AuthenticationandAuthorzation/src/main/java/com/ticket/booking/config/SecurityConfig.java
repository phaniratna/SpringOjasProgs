package com.ticket.booking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/ticket/**").hasAnyRole("admin","guest")
		.and().formLogin();
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/api/admin/**").hasAnyRole("admin")
		.and().formLogin();
		
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) 
			throws Exception {
		
		auth.inMemoryAuthentication().withUser("sunil")
		.password("{noop}sunil")
		.roles("admin","guest");
		
		
		auth.inMemoryAuthentication().withUser("arun")
		.password("{noop}arun")
		.roles("guest");
	}
}
