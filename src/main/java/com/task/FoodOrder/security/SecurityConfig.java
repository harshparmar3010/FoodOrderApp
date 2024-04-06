package com.task.FoodOrder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.task.FoodOrder.service.restaurant.RestaurantService;

@Configuration
public class SecurityConfig {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// Customizer.withDefaults()
		http.csrf(csrf -> csrf.disable());
		http.authorizeHttpRequests(
				(authorize) -> authorize
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.requestMatchers("/restaurant/**").hasRole("RESTAURANT")
				.requestMatchers("/login","/registration","/**").permitAll().anyRequest().authenticated());
		http.formLogin(form -> form.loginPage("/login").loginProcessingUrl("/login").failureUrl("/login?error=1").usernameParameter("email")
				.successHandler((request, response, authentication) -> {
					  for (GrantedAuthority authority : authentication.getAuthorities()) {
						  if (authority.getAuthority().equals("ROLE_RESTAURANT")) 
						  {
							  response.sendRedirect("/restaurant/" + restaurantService.getRestaurantByEmail(authentication.getName()).getId());
							  return;
						  } 
						  else if (authority.getAuthority().equals("ROLE_ADMIN")) 
						  {
							  response.sendRedirect("/admin");
							  return;
						  } 
					  }
					  response.sendRedirect("/");
				}));
		http.exceptionHandling(handling -> handling.accessDeniedPage("/403"));
		return http.build();
	}

}
