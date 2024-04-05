package com.springbootwebapp.TodoApp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurity {
	
	@Bean
	public InMemoryUserDetailsManager createUserDetail() {
		UserDetails userDetails1 = createNewUser("Fazil", "Fazil100%");
		UserDetails userDetails2 = createNewUser("Irfan", "Irfan100%");
		UserDetails userDetails3 = createNewUser("Joshua", "Joshua100%");
		UserDetails userDetails4 = createNewUser("Sriram", "Sriram100%");
		
		return new InMemoryUserDetailsManager(userDetails1 , userDetails2 , userDetails3 , userDetails4);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
		= input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
									.passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER","ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated());
			http.formLogin(withDefaults());
			http.csrf().disable();
			http.headers().frameOptions().disable();
			return http.build();
		
	}
}
