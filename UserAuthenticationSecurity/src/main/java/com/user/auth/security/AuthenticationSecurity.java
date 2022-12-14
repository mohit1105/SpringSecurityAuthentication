package com.user.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.user.auth.service.UserDetailServices;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class AuthenticationSecurity extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailServices UserDetailService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/signin").permitAll().antMatchers("/admin/**").hasRole("NORMAL").antMatchers("/users/**")
				.hasRole("ADMIN").anyRequest().authenticated().and().httpBasic().and().formLogin().loginPage("/signin").loginProcessingUrl("/dologin").defaultSuccessUrl("/user/");

	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(UserDetailService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10);
	}


	
}