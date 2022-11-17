package com.springreservation.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("customerLoginController")
@RequestMapping("/login")
public class LoginController {
    
    @GetMapping("")
    public String loginpage(){
        return "customer.login.login";
    }

    @GetMapping("/signup")
    public String signuppage(){
        return "customer.login.signup";
    }
}
