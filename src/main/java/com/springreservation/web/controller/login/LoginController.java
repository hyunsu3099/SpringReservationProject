/**
 * LoginController.java
 * 로그인 및 회원가입에 관련된 uri 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-25
 */

package com.springreservation.web.controller.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springreservation.web.dto.LoginDto;
import com.springreservation.web.dto.SignupDto;
import com.springreservation.web.service.MemberService;

@Controller("LoginController")
@RequestMapping("")
public class LoginController {

    //SecurityConfig에서 패스워드 엔코더 빈 객체 생성
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberService memberService;
     
    @GetMapping("/login")
    public String loginpage(HttpServletRequest request){
        //로그인 후 다시 돌아올 페이지 기억
        String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
        return "customer.login.login";
    }

    @PostMapping("/login")
    public @ResponseBody String login(HttpServletRequest request, @RequestBody LoginDto loginDto){
        //TODO : 로그인 성공시 로그인정보 세션에 추가
        return memberService.findPwByLoginEmail(null);
    }

    @GetMapping("/signup")
    public String signuppage(HttpServletRequest request){
        //회원가입 후 다시 돌아올 페이지 기억
        String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
        return "customer.login.signup";
    }

    @PostMapping("/signup")
    public @ResponseBody Map signup(HttpServletRequest request, @RequestBody SignupDto signupDto){

        //이메일정보로 회원가입시 Role : MEMBER
        if(signupDto.getRole().equals("member")){
            if(!memberService.emailExists(signupDto.getEmail())){
                memberService.signup( signupDto.getMember(bCryptPasswordEncoder));
            }
        //전화번호로 회원가입시 Role : NONMEMBER
        }else{
            if(!memberService.phoneExists(signupDto.getPhone())){
                memberService.signup( signupDto.getMember(bCryptPasswordEncoder));
            }
        }

        Map<String, Object> response = new HashMap<>();
        response.put("redirectURl", request.getSession().getAttribute("prevPage"));
        response.put("status","success");
        return response;
    }
}
