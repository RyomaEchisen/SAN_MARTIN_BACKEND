package com.san.martin.auth;

import java.util.Arrays;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

  @Override
  public void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_usuario/usuarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api_usuario/usuarios/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_usuario/usuarios").permitAll()
		.antMatchers(HttpMethod.DELETE,"/api_usuario/usuarios/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_usuario/usuarios").permitAll();
		
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/personas").permitAll()
		.antMatchers(HttpMethod.GET, "/api/personas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api/personas").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api/personas/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api/personas").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_archivo/archivos").permitAll()
		.antMatchers(HttpMethod.GET, "/api_archivo/archivos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_archivo/archivos").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_archivo/archivos/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_archivo/archivos").permitAll();
		
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_tipoFormulario/tipoFormularios").permitAll()
		.antMatchers(HttpMethod.GET, "/api_tipoFormulario/tipoFormularios/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_tipoFormulario/tipoFormularios").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_tipoFormulario/tipoFormularios/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_tipoFormulario/tipoFormularios").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_sucursal/sucursales").permitAll()
		.antMatchers(HttpMethod.GET, "/api_sucursal/sucursales/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_sucursal/sucursales").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_sucursal/sucursales/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_sucursal/sucursales").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_roles/roles").permitAll()
		.antMatchers(HttpMethod.GET, "/api_roles/roles/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_roles/roles").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_roles/roles/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_roles/roles").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_referencia/referencias").permitAll()
		.antMatchers(HttpMethod.GET, "/api_referencia/referencias/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_referencia/referencias").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_referencia/referencias/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_referencia/referencias").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_idioma/idiomas").permitAll()
		.antMatchers(HttpMethod.GET, "/api_idioma/idiomas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_idioma/idiomas").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_idioma/idiomas/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_idioma/idiomas").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_hojaDeVida/hojaDeVidas").permitAll()
		.antMatchers(HttpMethod.GET, "/api_hojaDeVida/hojaDeVidas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_hojaDeVida/hojaDeVidas").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_hojaDeVida/hojaDeVidas/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_hojaDeVida/hojaDeVidas").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_funcionario/funcionarios").permitAll()
		.antMatchers(HttpMethod.GET, "/api_funcionario/funcionarios/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_funcionario/funcionarios").permitAll()
		.antMatchers(HttpMethod.DELETE,"/api_funcionario/funcionarios/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_funcionario/funcionarios").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_formulario/formularios").permitAll()
		.antMatchers(HttpMethod.GET, "/api_formulario/formularios/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_formulario/formularios").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_formulario/formularios/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_formulario/formularios").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_formacionAcademica/formacionAcademicas").permitAll()
		.antMatchers(HttpMethod.GET, "/api_formacionAcademica/formacionAcademicas/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_formacionAcademica/formacionAcademicas").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_formacionAcademica/formacionAcademicas/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_formacionAcademica/formacionAcademicas").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_experienciaLaboral/experienciaLaborales").permitAll()
		.antMatchers(HttpMethod.GET, "/api_experienciaLaboral/experienciaLaborales/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_experienciaLaboral/experienciaLaborales").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_experienciaLaboral/experienciaLaborales/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_experienciaLaboral/experienciaLaborales").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_evento/eventos").permitAll()
		.antMatchers(HttpMethod.GET, "/api_evento/eventos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_evento/eventos").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_evento/eventos/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_evento/eventos").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_distincion/distinciones").permitAll()
		.antMatchers(HttpMethod.GET, "/api_distincion/distinciones/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_distincion/distinciones").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_distincion/distinciones/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_distincion/distinciones").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_cursos/cursos").permitAll()
		.antMatchers(HttpMethod.GET, "/api_cursos/cursos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_cursos/cursos").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_cursos/cursos/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_cursos/cursos").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_conocimiento/conocimientos").permitAll()
		.antMatchers(HttpMethod.GET, "/api_conocimiento/conocimientos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_conocimiento/conocimientos").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_conocimiento/conocimientos/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_conocimiento/conocimientos").permitAll();
		
		http.authorizeRequests().antMatchers(HttpMethod.GET,"/api_catalogo/catalogos").permitAll()
		.antMatchers(HttpMethod.GET, "/api_catalogo/catalogos/{id}").permitAll()
		.antMatchers(HttpMethod.POST, "/api_catalogo/catalogos").permitAll()
		.antMatchers(HttpMethod.DELETE, "/api_catalogo/catalogos/{id}").permitAll()
		.antMatchers(HttpMethod.PUT, "/api_catalogo/catalogos").permitAll();
		
		
		
		
		
		
		
		
		/*	
	.anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());
		
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		//config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));  //endpoint que consumira servicios
		//config.setAllowedOrigins(Arrays.asList("http://mi.empresa.bo"));   //entpoint para produccion
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(true);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter());
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
	*/
  }}

 

