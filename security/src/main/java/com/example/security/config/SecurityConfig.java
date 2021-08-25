package com.example.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JsonAuthenticationEntryPoint jsonAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.headers().frameOptions().sameOrigin();

        http.exceptionHandling()
                .authenticationEntryPoint(jsonAuthenticationEntryPoint);

        http.formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/sign")
                .successForwardUrl("/welcome")
                .failureUrl("/fail")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.getWriter().write("{\"code\":200, \"msg\":\"success\"}");
                    }
                })
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                        response.setStatus(HttpStatus.FORBIDDEN.value());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.getWriter().write("{\"code\":403, \"msg\":\"fail\"}");
                    }
                })
                .permitAll();

        http.logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll();

        http.authorizeRequests()
                .antMatchers("/other")
                .permitAll();

        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/*", "/js/*", "/img/*");
    }
}
