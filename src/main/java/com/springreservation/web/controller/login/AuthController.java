package com.springreservation.web.controller.login;

/**
 * AuthController.java
 * 회원 인증에 관한 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-30, 최종수정 2022-12-1
 */

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springreservation.web.entity.User;

@Controller
@RequestMapping("/auth")
public class AuthController {
    
    //로그인 되어있는 회원 이름 반환
    @GetMapping("/name")
    @ResponseBody
    public String getName(Authentication authentication){
        User user =(User) authentication.getPrincipal();
        return "{ \"result\" : [ {\"name\": \""+user.getName() + "\"} ] }";
    }
}
