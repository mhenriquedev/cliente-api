package com.desafio.mirante.security;

 import java.util.ArrayList;  
 import java.util.List;  
   
 import org.springframework.context.annotation.Bean;  
 import org.springframework.security.config.annotation.web.builders.HttpSecurity;  
 import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;  
 import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;  
 import org.springframework.security.config.http.SessionCreationPolicy;  
 import org.springframework.web.cors.CorsConfiguration;  
 import org.springframework.web.cors.CorsConfigurationSource;  
 import org.springframework.web.cors.UrlBasedCorsConfigurationSource;  
   
 @EnableWebSecurity  
 public class SecurityConfig extends WebSecurityConfigurerAdapter {  
   
   @Override  
   public void configure(HttpSecurity http) throws Exception {  
     http.csrf().disable(); 
   
     http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
   
     http.headers().frameOptions().sameOrigin();
   
     http.cors(); 
   
   }  
   
   @Bean  
   public CorsConfigurationSource corsConfigurationSource() {  
     final CorsConfiguration configuration = new CorsConfiguration();  
   
     
   
     List<String> allowedOrigins = new ArrayList<>();  
     allowedOrigins.add("*"); 
     configuration.setAllowedOrigins(allowedOrigins);  
   
     List<String> allowedMethods = new ArrayList<>();  
     allowedMethods.add("HEAD");  
     allowedMethods.add("GET");  
     allowedMethods.add("POST");  
     allowedMethods.add("PUT");  
     allowedMethods.add("DELETE");  
     allowedMethods.add("PATCH");  
     configuration.setAllowedMethods(allowedMethods);  
   
     
     configuration.setAllowCredentials(true);  
   
     List<String> allowedHeaders = new ArrayList<>();  
     allowedHeaders.add("Authorization");  
     allowedHeaders.add("Cache-Control");  
     allowedHeaders.add("Content-Type");  
     configuration.setAllowedHeaders(allowedHeaders);  
   
     
     final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
     source.registerCorsConfiguration("/**", configuration);  
   
     return source;  
   }  
 }  