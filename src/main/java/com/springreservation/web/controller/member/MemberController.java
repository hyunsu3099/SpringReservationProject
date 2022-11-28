/**
 * MemberController.java
 * 회원계정 정보보기 및 정보수정 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */

package com.springreservation.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("MemberController")
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/info")
    public String info(){
        return "member.member.info";
    }
    
    @GetMapping("/update")
    public String update(){
        return "member.member.update";
    }

}
