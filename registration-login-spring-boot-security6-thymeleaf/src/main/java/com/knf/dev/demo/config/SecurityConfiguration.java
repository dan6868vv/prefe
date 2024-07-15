package com.knf.dev.demo.config;

import com.knf.dev.demo.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .authorizeHttpRequests((requests) -> requests
                      .requestMatchers("/registration").permitAll()
                      .requestMatchers("/admin/users").hasRole("ADMIN")
                      .requestMatchers("/admin/forUser").hasRole("USER")
                      .anyRequest().authenticated()
              )
              .formLogin((form) -> form
                      .loginPage("/login")
                      .usernameParameter("email")
                      .permitAll()
              )
              .logout((logout) -> logout
                      .logoutUrl("/logout")
                      .logoutSuccessUrl("/")
                      .invalidateHttpSession(true)
              );

      return http.build();
   }
}