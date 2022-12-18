/**
 * OrderDto.java
 * 예약주문 전달 객체
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-6, 최종수정 2022-12-18
 */
package com.springreservation.web.dto;

import com.springreservation.web.entity.ReservationOrder;

public class OrderDto {
    private String reservationId;
    private String reservationDate;
    private String timeStart;
    private String timeEnd;
    private boolean enabledYn;
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

    public ReservationOrder getReservationOrder(){
        
        ReservationOrder order = new ReservationOrder();

        return null;
    }
}
