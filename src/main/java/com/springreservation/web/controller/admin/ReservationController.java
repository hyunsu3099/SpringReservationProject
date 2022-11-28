/**
 * ReservationController.java
 * 관리자계정의 예약페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-11-28
 */
package com.springreservation.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminReservationController")
@RequestMapping("/admin/reservation")
public class ReservationController {

    @GetMapping("")
    public String reservation(){
        return "admin.reservation.reservation";
    }
    
    @GetMapping("/detail")
    public String detail(){
        return "admin.reservation.detail";
    }

    @GetMapping("/list")
    public String list(){
        return "admin.reservation.list";
    }
}
