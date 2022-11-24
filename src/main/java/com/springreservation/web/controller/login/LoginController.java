/**
 * LoginController.java
 * 로그인 및 회원가입에 관련된 url 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */

package com.springreservation.web.controller.login;

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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberService memberService;
     
    @GetMapping("")
    public String loginpage(HttpServletRequest request){
        //로그인 후 다시 돌아올 페이지 기억
        String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
        return "customer.login.login";
    }
    @PostMapping
    public @ResponseBody String login(HttpServletRequest request, @RequestBody LoginDto loginDto){

        return "";
    }

    @GetMapping("/signup")
    public String signuppage(HttpServletRequest request){
        //회원가입 후 다시 돌아올 페이지 기억
        String referrer = request.getHeader("Referer");
	    request.getSession().setAttribute("prevPage", referrer);
        return "customer.login.signup";
    }

    @PostMapping("/signup")
    public String signup(HttpServletRequest request, @RequestBody SignupDto signupDto){

        if(signupDto.isDisposibleYn()){
            if(!memberService.emailExists(signupDto.getEmail())){
                memberService.signup(signupDto.getMember(bCryptPasswordEncoder));
            }
        }else{
            if(!memberService.phoneExists(signupDto.getPhone())){
                memberService.signup(signupDto.getMember(bCryptPasswordEncoder));
            }
        }

        String redirectURl =  request.getSession().getAttribute("prevPage").toString();
        return redirectURl;
    }
}
