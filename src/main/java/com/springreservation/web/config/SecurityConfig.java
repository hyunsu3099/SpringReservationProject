package com.springreservation.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        http
            // .csrf().disable() : csrf 기능 활성화를위해 disable 비활성화
        //login 페이지 url, 기본 successurl: index
            .formLogin()
                .loginPage("/login")
                .and()
        // 유저권한, admin 권한 설정
            .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").access("hasRole(ADMIN)")
                .anyRequest().permitAll();
    }

    //사용하지 않음
    //자바스크립트를 이용해 세션에 csrf 토큰 저장시 sessionRepository 객체 생성
    @Bean
    HttpSessionCsrfTokenRepository sessionRepository(){
        HttpSessionCsrfTokenRepository sessionRepository = new HttpSessionCsrfTokenRepository();

        sessionRepository.setHeaderName("X-CSRF-TOKEN");
        sessionRepository.setParameterName("_csrf");
        sessionRepository.setSessionAttributeName("CSRF_TOKEN");
        
        return sessionRepository;
    }
}