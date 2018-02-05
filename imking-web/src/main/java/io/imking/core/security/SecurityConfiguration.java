package io.imking.core.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import io.imking.core.filter.JWTAuthenticationFilter;
import io.imking.core.filter.JWTLoginFilter;

@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	static final String SELF_CSRF_COOKIE_NAME = "_token";
	
	@Autowired
	protected DataSource dataSource;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/assets/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jdbcUserDetailsManager()) ;
	}
	
	public UserDetailsManager jdbcUserDetailsManager() throws Exception {
		JdbcUserDetailsManager userMan = new JdbcUserDetailsManager();
		userMan.setDataSource( dataSource ) ;
		userMan.setRolePrefix("ROLE_");
		userMan.setAuthoritiesByUsernameQuery("SELECT account as username,'admin' as authority FROM t_user where account = ?");
		return userMan;
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
		AuthenticationManager authenticationManager = authenticationManager(); 
		http.addFilter(new JWTLoginFilter( authenticationManager )) ;
		http.addFilter(new JWTAuthenticationFilter(authenticationManager) ) ; 
		
	}
	
}
