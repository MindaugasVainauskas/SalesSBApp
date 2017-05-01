package com.sales.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter{
	
	@Override
	public void configure(HttpSecurity httpSec) throws Exception{
		httpSec.authorizeRequests()
				.antMatchers("/showProducts", "/addProduct", "/showCustomers", "/addCustomer", "/showOrders"
						, "/addOrder").hasRole("USER")//requests going to any page with / before it will require authentication
			.and()
				.formLogin().permitAll()//form authentication is used.
			.and()
				.logout().permitAll();//allow anyone to log out
	}
	
	@Autowired
	public void ConfigureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication()
			.withUser("user").password("user").roles("USER", "ADMIN");
	}

}
