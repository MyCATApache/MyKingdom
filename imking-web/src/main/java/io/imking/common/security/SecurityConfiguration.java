package io.imking.common.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
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

import io.imking.common.filter.JWTAuthenticationFilter;
import io.imking.common.filter.JWTLoginFilter;


@Configurable
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	static final String SELF_CSRF_COOKIE_NAME = "_token";
	
	@Autowired
	protected DataSource dataSource;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(jdbcUserDetailsManager()) ;
	}
	
	public UserDetailsManager jdbcUserDetailsManager() throws Exception {
		JdbcUserDetailsManager userMan = new JdbcUserDetailsManager();
		userMan.setDataSource( dataSource ) ;
		userMan.setRolePrefix("ROLE_");
		userMan.setUsersByUsernameQuery( "SELECT account as username,pwd as password,1 enabled FROM imk_user where account = ?" ); 
		userMan.setAuthoritiesByUsernameQuery("SELECT account AS username, t_role.role_code AS authority FROM t_user JOIN t_user_role ON t_user_role.user_id = t_user.id JOIN t_role ON t_role.id = t_user_role.role_id WHERE t_user.account = ?");
		return userMan;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.cors().and().csrf().disable().authorizeRequests()  
         .antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()  
         .anyRequest().authenticated()  
         .and()  
         .addFilter(new JWTLoginFilter(authenticationManager()))  
         .addFilter(new JWTAuthenticationFilter(authenticationManager()));  
		 
		 
//		FormLoginConfigurer<HttpSecurity> formLogin = http.formLogin();
//		http.authorizeRequests().antMatchers("/admin/**").hasAnyRole("admin")
//		.anyRequest().permitAll();
//		
//		formLogin.loginPage("/admin/login.html").permitAll().loginProcessingUrl("/admin/login.html").successForwardUrl("/admin/loginSuccess").permitAll()
//		.failureUrl("/admin/loginFailure");
//		CookieCsrfTokenRepository withHttpOnlyFalse = CookieCsrfTokenRepository.withHttpOnlyFalse();
//		withHttpOnlyFalse.setCookieName(SELF_CSRF_COOKIE_NAME);
//		withHttpOnlyFalse.setHeaderName(SELF_CSRF_COOKIE_NAME);
//		http.csrf().csrfTokenRepository(withHttpOnlyFalse);
//		http.csrf().disable();
//		AuthenticationManager authenticationManager = authenticationManager(); 
//		
//		JWTLoginFilter jwtLoginFilter = new JWTLoginFilter( authenticationManager );
//		jwtLoginFilter.setFilterProcessesUrl( "/admin/login.html" );
//		jwtLoginFilter.setAllowSessionCreation( false );
//		//jwtLoginFilter.setContinueChainBeforeSuccessfulAuthentication(true); 
//		http.addFilter( jwtLoginFilter ) ;
//		http.addFilter(new JWTAuthenticationFilter(authenticationManager) ) ; 
		
	}
	
}
