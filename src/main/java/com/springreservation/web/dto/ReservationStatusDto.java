/**
 * ReservationStatusDto.java
 * 해당 날짜에 예약이 가능한지를 보여주기 위한 데이터 전송 
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-15
 */
package com.springreservation.web.dto;

public class ReservationStatusDto {
    private String reservationDate;
    private String reservationTime;
    private String reservationName;
    private int status =2; //0:예약마감 1:예약임박 2예약가능
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
    public String getReservationName() {
        return reservationName;
    }
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}
