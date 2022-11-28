/**
 * SecurityConfig.java
 * 스프링 시큐리티 설정
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-28
 */
package com.springreservation.web.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import com.springreservation.web.service.MemberLoginService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    //MemberLoginService 클래스가 시큐리티 필터 체인에서 불러와지도록 등록
    private UserDetailsService userDetailsService;
    @Autowired
    public SecurityConfig(MemberLoginService memberLoginService){
        this.userDetailsService = memberLoginService;
    }

    //UsernotfoundException을 등록하기 위해 오버라이딩
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encodePwd());
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    //
    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        http
        //login 페이지 url, 기본 successurl: 
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/loginSuccess", false)
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                            AuthenticationException exception) throws IOException, ServletException {
                        
                        String errormessage = "";
                        if(exception instanceof UsernameNotFoundException) errormessage = "id notfound";
                        else errormessage = "pw notfound";
                        
                        response.getWriter().println("{errormessage: '" + errormessage +"'}");
                    }
                })
                .and()
        // 유저권한, admin 권한 설정
            .authorizeRequests()
                .antMatchers("/member/**","/member").authenticated()
                .antMatchers("/admin/**","/admin").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
        //로그아웃 설정
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .deleteCookies("JSESSIONID","remember-me");
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