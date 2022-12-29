/**
 * ReservationOrder.java
 * 예약주문 테이블 데이터 전달을 위한 entity 클래스
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-19
 *  */
package com.springreservation.web.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ReservationOrder {
    private int id;
    private int memberId;
    private String reservationId;
    private String reservationDate;
    private String timeStart;
    private String timeEnd;
    private boolean enabledYn;
    private List<ReservationTime> list;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<ReservationTime> getList() {
        return list;
    }
    public void setList(List<ReservationTime> list) {
        this.list = list;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    public String getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
    public boolean isEnabledYn() {
        return enabledYn;
    }
    public void setEnabledYn(boolean enabledYn) {
        this.enabledYn = enabledYn;
    }

    public void setList() {
        SimpleDateFormat formatter = new SimpleDateFormat("hhmm");
        List<ReservationTime> list = new ArrayList<>();

        try{
            Date start = formatter.parse(this.timeStart);
            Calendar cal = Calendar.getInstance(); cal.setTime(start);
            Calendar end =  Calendar.getInstance(); end.setTime(formatter.parse(this.timeEnd));

            while(cal.before(end)){
                ReservationTime reservationTime= new ReservationTime();
                reservationTime.setTimeStart(formatter.format(cal.getTime()));

                list.add(reservationTime);
                cal.add(Calendar.MINUTE,30);
            }

        }catch(ParseException e){
            e.printStackTrace();
        }
        
        this.list = list;
    }
}
