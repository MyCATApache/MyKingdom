package io.imking.core.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	static final String SELF_CSRF_COOKIE_NAME = "_token";
	

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("1").roles("admin");
	}

	protected void configure(HttpSecurity http) throws Exception {
		FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();
		http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("admin")
		.anyRequest().permitAll();
		
		formLogin.loginPage("/api/login.html").loginProcessingUrl("/api/login.html").successForwardUrl("/admin/loginSuccess").permitAll()
		.failureUrl("/admin/loginFailure");
		CookieCsrfTokenRepository withHttpOnlyFalse = CookieCsrfTokenRepository.withHttpOnlyFalse();
		withHttpOnlyFalse.setCookieName(SELF_CSRF_COOKIE_NAME);
		withHttpOnlyFalse.setHeaderName(SELF_CSRF_COOKIE_NAME);
		http.csrf().csrfTokenRepository(withHttpOnlyFalse);
		http.csrf().disable();
		
		http.headers().addHeaderWriter(new AccessControlHeaderWriter()); 
	}
	
}
