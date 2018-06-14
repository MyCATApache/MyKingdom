package io.imking.common.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

import io.imking.common.filter.JWTAuthenticationFilter;
import io.imking.common.filter.JWTLoginFilter;
import io.imking.common.services.MyUserDetailsService;


@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	static final String SELF_CSRF_COOKIE_NAME = "_token";

	private static final String[] AUTH_WHITELIST = {
			"/api/user/findPassward"
	};
	
	@Autowired
	protected DataSource dataSource;
	
     @Autowired
	 private MyUserDetailsService userDetailsService;
	 
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/static/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService));
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		 http.cors().and().csrf().disable()
		 .authorizeRequests()
		 .antMatchers(AUTH_WHITELIST).permitAll()  //方便测试用
         .antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()  
         .anyRequest().authenticated()  
         .and()  
         .addFilter(new JWTLoginFilter(authenticationManager()))  
         .addFilter(new JWTAuthenticationFilter(authenticationManager()));  
	}
	
}