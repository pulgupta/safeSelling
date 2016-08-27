package com.org.safeSelling.config;

//import javax.sql.DataSource;

//import org.springframework.beans.factory.annotation.Autowired;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.org.safeSelling.dao.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	DataSource dataSource;

	@Autowired
	UserRepository userRepository;

	@Override
	protected void configure (HttpSecurity http) throws Exception{
		/*http.authorizeRequests().anyRequest().authenticated()
		.and().formLogin().and().httpBasic();*/

		http.formLogin().loginPage("/login").failureUrl("/login?error=true").permitAll()
		.and().logout().invalidateHttpSession(true).
		//this is included here and will only act for the post calls which are coming
		//on this url pattern.
		logoutUrl("/logout").logoutSuccessUrl("/")
		.and().authorizeRequests()
		//.antMatchers(HttpMethod.POST, "/user/**").authenticated()
		.antMatchers("/user/profile/**").authenticated()
		.antMatchers(HttpMethod.POST, "/items").authenticated()
		.anyRequest().permitAll();
	}

	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception{

		/*
		auth.inMemoryAuthentication()
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");


		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(new StandardPasswordEncoder("53cr3t"))
		.withUser("user").password("password").roles("USER").and()
		.withUser("admin").password("password").roles("USER", "ADMIN");
		 */

		//enabling custom authentication and authorization
		auth.userDetailsService(new UserSecurityService(userRepository));
	}

}
