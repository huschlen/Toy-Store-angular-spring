package com.naoko.inventory.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.Order;
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

@EnableWebSecurity
@Order(200)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth
	            .inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER");
	    }
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			
			// The pages requires login as USER.
			// If no login, it will redirect to /login page.
			http.authorizeRequests().antMatchers("/toys","/home")
				.access("hasAnyRole('USER')");
 
			// When the user has logged in as XX.
			// But access a page that requires role YY,
			// AccessDeniedException will throw.
			http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
			// Config for Login Form
			/*http.authorizeRequests().and().formLogin()
			.loginProcessingUrl("/j_spring_security_check") // Submit URL
			.loginPage("/login")
			.defaultSuccessUrl("/accountInfo")
			.failureUrl("/login?error=true")
			.usernameParameter("userName")
			.passwordParameter("password")
			// Config for Logout Page
			// (Go to home page).
			.and().logout().logoutUrl("/logout").logoutSuccessUrl("/");*/
	 
	   }
	}
}
