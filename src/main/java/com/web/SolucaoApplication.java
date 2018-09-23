package com.web;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableOAuth2Sso
//@EnableScheduling
@RestController
public class SolucaoApplication extends WebSecurityConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(SolucaoApplication.class, args);
	}
	
    @RequestMapping("/user")
    public Principal user(Principal principal) {
        return principal;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http                
//                .authorizeRequests()
//                .antMatchers("/", "/login**", "/webjars/**", "/error**", "/movie/all", "/movie/add", "/movie/image/**", "/movie/new").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().logout().logoutSuccessUrl("/").permitAll()
//                .and().csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    	
    	  http
          .authorizeRequests()
          .antMatchers( "/**").permitAll()
          .antMatchers( "/private/**").authenticated()
          .anyRequest().authenticated()
          .and()
          .formLogin()
          .loginPage("/login")
          .permitAll()
          .and()
          .logout()
          .permitAll();    	
    }	    
}
