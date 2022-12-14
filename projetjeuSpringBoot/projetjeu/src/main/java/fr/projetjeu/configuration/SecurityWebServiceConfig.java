package fr.projetjeu.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityWebServiceConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// @formatter:off
		return http.antMatcher("/api/**")
						.csrf().disable()
					//plus de session pour l'authentification
				   .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				   .and()
				   .authorizeRequests()
				        .antMatchers(HttpMethod.POST,"/api/compte").permitAll()
				   		.antMatchers(HttpMethod.OPTIONS).permitAll()
				   		.antMatchers(HttpMethod.POST).authenticated()
				   		.antMatchers(HttpMethod.PUT).authenticated()
				   		.antMatchers(HttpMethod.DELETE).authenticated()
				   		.anyRequest().authenticated()
				   .and()
				   		//plus de formulaire on envoie dans le header de la requete le login, password
				   		.httpBasic()
				   .and()
				   .build();
		// @formatter:on

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
