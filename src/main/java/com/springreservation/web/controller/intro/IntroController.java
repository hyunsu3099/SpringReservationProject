/**
 * IntroController.java
 * 소개 페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */
package com.springreservation.web.controller.intro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("IntroController")
@RequestMapping("/intro")
public class IntroController {

    @GetMapping("")
    public String introduction(){
        return "all.introduction.introduction";
    }
    
}
