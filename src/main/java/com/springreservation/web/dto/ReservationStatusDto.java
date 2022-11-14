package com.springreservation.web.dto;

public class ReservationStatusDto {
    private String reservationDate;
    private String reservationRoom;
    private int status; //0:예약마감 1:예약가능 2예약마감
    private boolean statusAt9Yn; //9시 예약가능?
    private boolean statusAt12Yn; //12시 예약가능?
    private boolean statusAt15Yn; //15시 예약가능?
    private boolean statusAt18Yn;//18시 예약가능?
}
