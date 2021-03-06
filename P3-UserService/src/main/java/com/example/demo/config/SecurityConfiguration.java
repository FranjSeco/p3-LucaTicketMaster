package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.security.TipoPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("lame")
	private TipoPasswordEncoder encoder;

	@Autowired
	private DataSource dataSource;

	// Estos datos se encuentran el .properties
	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.usersByUsernameQuery(usersQuery)
			.authoritiesByUsernameQuery(rolesQuery)
			.dataSource(dataSource)
		
			.passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
		.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/v3/api-docs").permitAll()
		.antMatchers("/swagger-ui/**").permitAll()
		.antMatchers("/users/**").permitAll()
		.antMatchers("/console/**").permitAll()
		.antMatchers("/register").permitAll()
		.anyRequest().authenticated()
			.and()
		.csrf()
			.disable()
			.formLogin().loginPage("/login")
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
		.csrf()
			.disable()
			.headers().frameOptions().disable()
			.and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/")
			.and()
		.exceptionHandling()
			.accessDeniedPage("/access-denied");
		
	}
	//Para ignorar la seguridad en estos ficheros
	@Override
	public void configure(WebSecurity web) throws Exception {
		web
			.ignoring()
			.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html");
	}

}
