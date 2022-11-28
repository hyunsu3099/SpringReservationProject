/**
 * ReservationController.java
 * 회원계정의 예약페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */

package com.springreservation.web.controller.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("MemberReservationController")
@RequestMapping("/member/reservation")
public class ReservationController {

    @GetMapping("")
    public String reservation(){
        return "member.reservation.reservation";
    }
    
    @GetMapping("/detail")
    public String detail(){
        return "member.reservation.detail";
    }

    @GetMapping("/list")
    public String list(){
        return "member.reservation.list";
    }
}
