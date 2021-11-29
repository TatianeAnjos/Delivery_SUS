package com.tatiane.Delivery_SUS.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


//import com.tatianeanjos.security.JWTUtil;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment env;

	@Autowired
	private UserDetailsService userDetailsService;

//	@Autowired
//	private JWTUtil jwtUtil;

	private static final String[] PUBLIC_MATCHERS = {"/localhost:8080/**", "/h2-console/**","/orders/**","/swagger-ui/**"};

	private static final String[] PUBLIC_MATCHERS_GET = {"/localhost:8080/**","/swagger-ui/**", "/orders/**","/products/**", "/categories/**", "/entregadores/**"};

	private static final String[] PUBLIC_MATCHERS_POST = {"/localhost:8080/**","/swagger-ui/**", "/users/**", "/entregadores/**"};

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }
		
		http.cors().and().csrf().disable();
		http.authorizeRequests()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.PUT, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(HttpMethod.OPTIONS, PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS).permitAll()
			.antMatchers(PUBLIC_MATCHERS_GET).permitAll()
			.antMatchers(PUBLIC_MATCHERS_POST).permitAll()
			.antMatchers(
		            "/v2/api-docs", 
		            "/swagger-resources/**",  
		            "/swagger-ui.html", 
		            "/webjars/**" ,
	             "/users.*",
	              "/products.*",
	               "/orders.*",
		             /*Probably not needed*/ "/swagger.json").permitAll()
			.anyRequest().authenticated();
		
//		http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
//		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
//		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
