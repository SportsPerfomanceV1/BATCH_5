package com.example.sports_performance.Security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth/**").permitAll()  // Allow registration and login without JWT
                .antMatchers("/admin/**").hasRole("ADMIN")  // Protect admin routes
                .antMatchers("/athlete/**").hasRole("ATHLETE")  // Protect athlete routes
                .anyRequest().authenticated()  // All other requests need authentication
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))  // Add JWT filter
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);  // No session, use tokens
    }
}


