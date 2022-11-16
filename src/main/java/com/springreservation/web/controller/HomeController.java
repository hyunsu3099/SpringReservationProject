package com.springreservation.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springreservation.web.dto.ReservationStatusDto;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.service.ReservationService;

@Controller
public class HomeController{

    @Autowired
    ReservationService reservationService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/reservation/status")
    public void reservationStatus(@RequestParam String dayStr, HttpServletResponse response) {
        List<Reservation> list;
        List<ReservationStatusDto> result;
        if(dayStr!=null){list =reservationService.getReservationList(dayStr);}
		else{reservationService.getReservationList();}

        /*
         * Reservation 모델 -> ReservationStatusDto 로 바꾸는 로직 추가필요
         * 
         */
        int amountOfRooms = 4; int amountOfDays= 6;
        String[] rooms = {"A","B","C","D"};
        result = new ArrayList<ReservationStatusDto>();
        for(int i=0;i<amountOfRooms;i++) for(int j=0;j<amountOfDays;j++){
            ReservationStatusDto temp = new ReservationStatusDto();

            result.add(temp);
        }
		
		ObjectMapper oMap = new ObjectMapper();
		try {response.getWriter().print(oMap.writeValueAsString(result));}
		catch(IOException e) {System.out.println(e);}
    }
}