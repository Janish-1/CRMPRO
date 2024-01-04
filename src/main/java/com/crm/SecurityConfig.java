package com.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//SecurityConfig.java
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {

 @Autowired
 private UserDetailsServiceImpl userDetailsService;

 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 }

 @SuppressWarnings({ "deprecation", "removal" })
protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests()
             .requestMatchers("/admin/**").hasRole("ADMIN")
             .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")
             .requestMatchers("/hrmanager/**").hasAnyRole("ADMIN", "HRMANAGER")
             .requestMatchers("/salesmanager/**").hasAnyRole("ADMIN", "SALESMANAGER")
             .anyRequest().authenticated()
             .and()
             .formLogin()
             .and()
             .logout()
             .logoutSuccessUrl("/login")
             .and()
             .exceptionHandling().accessDeniedPage("/403");
 }

 @Bean
 public PasswordEncoder passwordEncoder() {
     return new BCryptPasswordEncoder();
 }
}
