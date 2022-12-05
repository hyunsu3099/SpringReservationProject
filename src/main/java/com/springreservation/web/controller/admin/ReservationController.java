/**
 * ReservationController.java
 * 관리자계정의 예약페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-2
 */
package com.springreservation.web.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("AdminReservationController")
@RequestMapping("/admin/reservation")
public class ReservationController {

    private final int isAdmin=1;

    @GetMapping("")
    public String reservation(){
        return "admin.head.reservation.list";
    }
    
    @GetMapping("/{id}")
    public String detail( @PathVariable int id){
        return "admin.reservation.detail";
    }

    @GetMapping("/history")
    public String list(){
        return "admin.head.reservation.history";
    }
}
