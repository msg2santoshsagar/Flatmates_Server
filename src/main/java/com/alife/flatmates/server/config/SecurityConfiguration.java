package com.alife.flatmates.server.config;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.alife.flatmates.server.security.AlwaysSendUnauthorized401AuthenticationEntryPoint;
import com.alife.flatmates.server.security.CustomAuthenticationEntryPoint;
import com.alife.flatmates.server.security.CustomAuthenticationFailureHandler;
import com.alife.flatmates.server.security.CustomAuthenticationSuccessHandler;
import com.alife.flatmates.server.security.CustomUserDetailService;


/**
 * To manage security
 * 
 * @author santosh sagar
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	private AuthenticationManagerBuilder authenticationManagerBuilder;

	@Autowired
	private CustomUserDetailService customUserDetailsService;
	
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
	
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler; 
	
	
	@PostConstruct
	public void init() {
		try {
			authenticationManagerBuilder
			.userDetailsService(customUserDetailsService)
			.passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			throw new BeanInitializationException("Security configuration failed", e);
		}
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	
	@Bean 
	public AlwaysSendUnauthorized401AuthenticationEntryPoint entryPoint(){
		return new AlwaysSendUnauthorized401AuthenticationEntryPoint();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		.exceptionHandling().authenticationEntryPoint(entryPoint())
		.and()
		.formLogin()
		.successHandler(customAuthenticationSuccessHandler)
		.failureHandler(customAuthenticationFailureHandler)
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/api/logout")
		.permitAll()
		.and()
		.authorizeRequests()
		.antMatchers("/api/register").permitAll()
		.antMatchers("/api/ping").permitAll()
		.antMatchers("/api/group/**").authenticated()
		.antMatchers("/api/fcm/**").authenticated()
		.antMatchers("/auth").authenticated();
		
		http.csrf().disable()/*.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())*/;
		http.httpBasic().authenticationEntryPoint(customAuthenticationEntryPoint);
		http.cors();
		
	}


}
