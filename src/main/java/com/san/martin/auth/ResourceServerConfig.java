package com.san.martin.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_usuario/usuarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api_usuario/usuarios/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_usuario/usuarios").permitAll()
		.antMatchers(HttpMethod.DELETE,"/api_usuario/usuarios/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_usuario/usuarios").permitAll()
		
		
		
		//http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_personas/personas").permitAll()
		//.antMatchers(HttpMethod.GET, "/api_personas/personas/{id}").permitAll()
		//.antMatchers(HttpMethod.POST, "/api_personas/personas").permitAll()
		//.antMatchers(HttpMethod.DELETE, "/api_personas/personas/{id}").permitAll()
		//.antMatchers(HttpMethod.PUT, "/api_personas/personas").permitAll()
	    .anyRequest().authenticated();
		  
		
		
		//.antMatchers(HttpMethod.GET, "/api_archivo/archivos/{id}").permitAll()
		//.antMatchers(HttpMethod.POST, "/api_archivo/archivos").permitAll()
		//.antMatchers(HttpMethod.DELETE, "/api_archivo/archivos/{id}").permitAll()
		//.antMatchers(HttpMethod.PUT, "/api_archivo/archivos").permitAll()
		//.anyRequest().authenticated();
	
	}
}
