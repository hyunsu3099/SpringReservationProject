/**
 * ReservationController.java
 * 관리자계정의 예약페이지 요청처리
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-7
 */
package com.springreservation.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springreservation.web.dto.ReservationStatusDto;
import com.springreservation.web.service.ReservationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller("AdminReservationController")
@RequestMapping("/admin/reservation")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private final int isAdmin=1;

    @GetMapping("")
    public ModelAndView reservation(){
    
        ModelAndView model = new ModelAndView();
        model.addObject("reservationNames", reservationService.getReservationNames());

        model.setViewName("admin.head.reservation.list");
        return model;
    }
    
    @GetMapping("/{id}")
    public ModelAndView detail( @PathVariable int id){
        ModelAndView model = new ModelAndView();
        model.addObject("reservationTimes", reservationService.getReservationTimes("1209",1));

        model.setViewName("admin.reservation.detail");
        return model;
    }

    @GetMapping("/history")
    public ModelAndView history(){
        return null;
    }

    @PostMapping(value="")
    @ResponseBody
    public String post(@RequestBody ReservationStatusDto reservationStatusDto) {
        //TODO: process POST request
        
        return "";
    }
    
}
