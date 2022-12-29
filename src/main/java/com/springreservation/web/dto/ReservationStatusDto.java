/**
 * ReservationStatusDto.java
 * 해당 날짜에 예약이 가능한지를 보여주기 위한 데이터 전송 
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-21
 */
package com.springreservation.web.dto;

import java.util.Iterator;
import java.util.Map;

public class ReservationStatusDto {
    private Map<String,Integer> reservationTime;    // String: "hhMM"형 시간
                                                    // Integer: 예약가능여부
    private String reservationDate;
    private int status = 2; //0:예약마감 1:예약임박 2예약가능
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Map<String, Integer> getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(Map<String, Integer> reservationTime) {
        this.reservationTime = reservationTime;
    }
    public void setStatus(){

        int total =0;
        int reservable =0;
        
        Iterator<String> keys = reservationTime.keySet().iterator();
        while( keys.hasNext() ){
            String strKey = keys.next();
            total++;
            reservable+=reservationTime.get(strKey);
        }

        if(reservable==0) this.status=0;    // 예약가능이 0일때
        else if(reservable*10/total <20) this.status=1; // 예약가능이 20% 이하일때
    }
}
