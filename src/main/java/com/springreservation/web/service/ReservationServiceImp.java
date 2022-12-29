/**
 * ReservationServoviceImp.java
 * 예약데이터 처리를 위한 서비스 구현
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-20
 */
package com.springreservation.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.dto.ReservationStatusDto;
import com.springreservation.web.entity.OrderView;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationOrder;
import com.springreservation.web.entity.ReservationTime;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
    static SimpleDateFormat timeFormatter = new SimpleDateFormat("hhmm");

    //getReservationNames : 예약테이블 목록들을 조회한다.
    //Reservation 형 list 반환
    @Override
    public List<Reservation> getReservationNames() {
        return reservationDao.getReservationNames();
    }

    //getReservatrionStatuses : 각 날짜, 시간에따라 예약가능여부를 db로 부터 조회하고 반환
    //startdate, enddate : string "yyyymmdd", reservationid: int
    //ReservationStatusDto 형 list 반환
    @Override
    public List<ReservationStatusDto> getReservatrionStatuses(String startdate, String enddate, int reservationId) throws ParseException{

        //controller로 반환할 리스트
        //리스트에는 startdate~enddate 날짜에 해당하는 ReservationDto가 담긴다.
        List<ReservationStatusDto> list = new ArrayList<>();

        // 0. 시간테이블 및 주문테이블을 dao를 통해 불러온다.
        // 1. 기간내에 조회되는 (startdate~enddate) 주문테이블 목록들의 시간을 set에 넣는다. (String : "yyyyMMddhhmm")
        // 2. 반환될 ReservationStatusDto 객체를 생성하고, 현재 주문가능한지 여부를 확인하여 입력한다.


        // 0. 시간테이블 및 주문테이블을 dao를 통해 불러온다.
        List<ReservationTime> times = reservationDao.getReservationTimes(reservationId);
        List<OrderView> orders = reservationDao.getOrders(startdate,enddate,reservationId);

         //1. 기간내에 조회되는 주문테이블 목록들의 시간을 set에 넣는다. (String : "yyyyMMddhhmm"
        //String "yyyyMMddhhmm" 주문 목록들이 담길 set
        Set<String> set = new HashSet<>();
        //
        for(OrderView order : orders){
            String dateStr = dateFormatter.format(order.getReservationDate());
            Date startTime = timeFormatter.parse(order.getTimeStart()) ;
            Date endTime = timeFormatter.parse(order.getTimeEnd());
            
            for(ReservationTime time : times){
                String timeStr = time.getTimeStart();
                if(timeFormatter.parse(timeStr).before(endTime) &
                timeFormatter.parse(timeStr).compareTo(startTime)>=0){
                    set.add(dateStr+timeStr);
                }
            }
        }

        // 2. 날짜별로 Dto 객체를 생성하기 위해 루프를 생성한다. (시작날짜~끝날짜까지)
        Date start = dateFormatter.parse(startdate); 
        Calendar cal = Calendar.getInstance(); cal.setTime(start);
        Calendar end = Calendar.getInstance(); end.setTime(dateFormatter.parse(enddate));
        
        while(cal.before(end)){
            ReservationStatusDto dto = new ReservationStatusDto();

            //dto에 날짜 입력
            String dateStr =dateFormatter.format(cal.getTime());
            dto.setReservationDate(dateStr);
            Map<String,Integer> map = new HashMap<>();

            // 2-1. 시작날짜부터 순서대로 각 시간객체를 생성 (복사)
            for(ReservationTime time : times){
                String timeStr = time.getTimeStart();
                map.put(timeStr,1);
                // 2-2. 각 날짜+시간에 주문이 가능한지를 set을 통해 확인하고 주문가능여부 map을 입력한다.
                if(set.contains(dateStr+timeStr))
                    map.replace(timeStr,0);
            }

            dto.setReservationTime(map);
            dto.setStatus();
            list.add(dto);
            cal.add(Calendar.DATE,1);
        }
        
        return list;
    }//end of getReservatrionStatuses(startdate,enddate,id)



    //getReservatrionStatuses : 각 날짜, 시간에따라 예약가능여부를 db로 부터 조회하고 반환
    //startdate, enddate : string "yyyymmdd" 날짜입력
    //ReservationStatusDto 형 리스트 반환
    //reservationid 입력이 존재하지 않을 경우로, 모든 reservation id를 조회하여 getReservatrionStatuses를 재귀호출한다.
    @Override
    public List<ReservationStatusDto> getReservatrionStatuses(String startdate){

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, 5);
        String enddate = dateFormatter.format(cal.getTime());

        List<ReservationStatusDto> list = new ArrayList<>();
        List<Reservation> reservations = reservationDao.getReservationNames();

        try{    //SimpleParsefommatter의 parseException예외감지
            for(Reservation reservation : reservations){
                list.addAll(getReservatrionStatuses(startdate,enddate,reservation.getId()));
            }
        }catch(ParseException e) {
            e.printStackTrace();
        }

        return list;
    }


    //getReservatrionStatuses : 각 날짜, 시간에따라 예약가능여부를 db로 부터 조회하고 반환
    //ReservationStatusDto 형 리스트 반환
    //startdate, enddate 입력이 존재하지 않을 경우로, 현재날짜와 5일뒤 날짜를 입력하여 getReservatrionStatuses를 재귀호출한다.
    @Override
    public List<ReservationStatusDto> getReservatrionStatuses(){
        
        Date date = new Date();
        String startdate = dateFormatter.format(date);

        return getReservatrionStatuses(startdate);
    }
    //end of getReservatrionStatuses()


    @Override
    public int order(ReservationOrder reservationOrder) {

        int orderid = 0;
        try{
            orderid = reservationDao.insertOrderDetail(reservationOrder);
            reservationOrder.setId(orderid);
            reservationOrder.setList();

            reservationDao.insertOrderTime(reservationOrder);
        }catch(Exception e){
            e.printStackTrace();
        }

        return orderid;
    }
}
