package com.wecp.progressive.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.wecp.progressive.jwt.JwtRequestFilter;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

    // implement security configuration here
    // register, login should be permitted to all
    // all other requests should be authenticated with valid JWT token


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/customer/register", "/customer/login").permitAll()
                .antMatchers(HttpMethod.GET, "/customers/**").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, "/customers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/customers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/customers/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, "/accounts/**").hasAnyAuthority("USER", "ADMIN") // Repeat for accounts
                .antMatchers(HttpMethod.POST, "/accounts/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/accounts/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/accounts/**").hasAuthority("ADMIN")
                .antMatchers("/credit-cards/**").hasAnyAuthority( "ADMIN")
                .antMatchers("/loans/**").hasAnyAuthority( "ADMIN")
                .antMatchers("/transactions/**").hasAnyAuthority("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        
        return super.authenticationManagerBean();
    }

    

    



}


