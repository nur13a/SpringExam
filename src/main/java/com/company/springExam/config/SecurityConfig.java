package com.company.springExam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("Admin").password(passwordEncoder().encode("123")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/student").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/student/delete/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/course").hasRole("ADMIN").
                antMatchers(HttpMethod.GET, "/student").permitAll()
                .antMatchers(HttpMethod.GET, "/student/find?fio=емеля").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable().headers().frameOptions().disable().and()

                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
