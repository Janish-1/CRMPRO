package com.crm;

import java.io.IOException;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//CustomAccessDeniedHandler.java
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

 @Override
 public void handle(HttpServletRequest request, HttpServletResponse response,
                    AccessDeniedException ex) throws IOException, ServletException {
     response.sendRedirect("/403");
 }

//SecurityConfig.java (Update)
@SuppressWarnings({ "deprecation", "removal" })
protected void configure(HttpSecurity http) throws Exception {
 http.authorizeRequests()
         // ...
         .and()
         .exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());
}
}
