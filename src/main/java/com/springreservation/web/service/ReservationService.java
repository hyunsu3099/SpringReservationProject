/**
 * ReservationServovice.java
 * 예약데이터 처리를 위한 서비스
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-7
 */
package com.springreservation.web.service;

import java.util.List;

import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationTime;

public interface ReservationService {
    public List<Reservation> getReservationList(String startdate, String enddate);
    public List<Reservation> getReservationList(String startdate);
    public List<Reservation> getReservationList();

    public List<Reservation> getReservationNames();

    public List<ReservationTime> getReservationTimes(String startdate, String enddate, int reservationId);
    public List<ReservationTime> getReservationTimes(String startdate, int reservationId);
}
