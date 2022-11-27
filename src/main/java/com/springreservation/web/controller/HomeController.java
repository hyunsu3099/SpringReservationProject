package com.springreservation.web.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@RequestMapping({"/",""})
public class HomeController{

    @Autowired
    ReservationService reservationService;

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("reservation/status")
    public void reservationStatus(@RequestParam String firstday, HttpServletResponse response) {

        List<Reservation> list;
        List<ReservationStatusDto> result;
        if(firstday!=null && firstday!=" " && firstday!=""){ list =reservationService.getReservationList(firstday); }
		else{list = reservationService.getReservationList();}


        //0. service 매서드를 통해 List<Reservation> list형의 예약목록들을 불러온 상태

        //1. 주문된 내용의 "방이름날짜시간 ex A20221120" 리스트의 index를 새 객체 hashmap에 넣는다.
        Map<String, List<Integer>> map = new HashMap<>();

        //list를 for 문으로 각 저장된 Resevation 객체를 불러온다 
        for(int i=0;i<list.size();i++){
            Reservation reservation = list.get(i);
            //Map의 Key 역할을 하는 String 키를 "방이름날짜시간 ex)A20221120" 형식으로 만든다.
            String tempStr = reservation.getReservationRoom()+reservation.getReservationDate();
            //Map의 Value 역할은 ArrayList<integer> 형으로, Key값에 해당하는 모든 Reservation의 위치(index)를 넣는다.
            List<Integer> arr = new ArrayList<>();
            arr.add(i); 
            //MAP 내에 Key가 이미 존재하는 경우 , 기존의 value인arraylist에 새로운값 i를 추가한다.
            if(map.containsKey(tempStr)) arr.addAll(map.get(tempStr));
            map.put(tempStr,arr);
        }
        

        //2.  result에 새 객체들을 생성해서 집어넣는다.
        result = new ArrayList<ReservationStatusDto>();
        //2-0.result의 List를 for루프를 이용해 값을 넣을 때 미리 알아야 할 값들을 정의   
        int amountOfRooms = 4; int amountOfDays= 6;
        String[] rooms = {"A","B","C","D"}; String[] times = {"0900","1200","1500","1800"};
        String[] days = new String[amountOfDays];

        //2-1 result for루프를 하기전, ReservationStatusDto 객체가 가질 날짜데이터를
        //    "yyyymmdd"형으로 정의하여 days[]배열에 넣는다.
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date firstDate;
		try {firstDate = formatter.parse(firstday);}
        catch (ParseException e) {firstDate=new Date();}
		Calendar cal = Calendar.getInstance();
        cal.setTime(firstDate);
        for(int i=0;i<amountOfDays;i++){
            days[i] = formatter.format(cal.getTime()); 
            cal.add(Calendar.DATE, 1);
        }

        //3. 각 result에 넣을 각 ReservationStatusDto 객체를
        // 각 방(A,B,C,D) => 각 날짜(6일) 에 대해 생성하고
        // 각 방 각 날짜에 대해 예약이 이미 있는지 map.containsKey()를 통해 확인한다.
        for(int i=0;i<amountOfRooms;i++) for(int j=0;j<amountOfDays;j++){
            //새로운 ReservationStatusDto 객체 생성
            ReservationStatusDto temp = new ReservationStatusDto();
            temp.setReservationDate(days[j]);
            temp.setReservationRoom(rooms[i]);
            //날짜, 방에 대해 예약이 있는지 map.containsKey()를 통해 확인
            if(map.containsKey(rooms[i]+days[j])){
                List<Integer> reservationOrderIndexes= map.get(rooms[i]+days[j]);
                // 예약이 있다면, 예약된 시간들을 입력
                for(int reservationOrderIndex :reservationOrderIndexes){
                    String reservedTime = list.get(reservationOrderIndex).getReservationTime();
                    if(reservedTime.equals(times[0]) ) temp.setStatusAt9(false);
                    else if(reservedTime.equals(times[1]) ) temp.setStatusAt12(false);
                    else if(reservedTime.equals(times[2]) )temp.setStatusAt15(false);
                    else if(reservedTime.equals(times[3]) )temp.setStatusAt18(false);
                }
            }
            result.add(temp);
        }
		
        //만들어진 result (dto 리스트)를 요청에 대한 응답으로 전달
		ObjectMapper oMap = new ObjectMapper();
		try {response.getWriter().print(oMap.writeValueAsString(result));}
		catch(IOException e) {System.out.println(e);}
    }
}