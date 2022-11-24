package com.springreservation.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{


    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        //csrf 임시 비활성화: 폼에 csrf 토큰 추가 이후 활성화 예정
        http.csrf().disable()
        //login 페이지 url, 기본 successurl: index
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/index")
                .and()
        // 유저권한, admin 권한 설정
            .authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/admin/**").access("hasRole(ADMIN)")
                .anyRequest().permitAll();
    }

}
