package com.naoko.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Web security configuration.
 * 
 * @author	Naoko Huschle
 * @since	2016-12-30
 *
 */

@Configuration
@EnableWebSecurity
@Order(200)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();	
		http
			.formLogin().and().authorizeRequests()
			.antMatchers(HttpMethod.GET, "/", "/toys")
			.hasRole("USER")
			.antMatchers(HttpMethod.POST, "/", "/toys")
			.hasRole("USER")
			.antMatchers(HttpMethod.PUT, "/", "/toys")
			.hasRole("USER")
			.antMatchers(HttpMethod.DELETE, "/", "/toys")
			.hasRole("USER")
			.anyRequest().permitAll();
			//.and()
			//.formLogin().loginPage("/login");
	}
		
}
