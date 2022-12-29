/**
 * ReservationServovice.java
 * 예약데이터 처리를 위한 서비스
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-7
 */
package com.springreservation.web.service;

import java.text.ParseException;
import java.util.List;

import com.springreservation.web.dto.ReservationStatusDto;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationOrder;

public interface ReservationService {

    public List<Reservation> getReservationNames();

    public List<ReservationStatusDto> getReservatrionStatuses(String startdate, String enddate, int reservationId) throws ParseException;
    public List<ReservationStatusDto> getReservatrionStatuses(String startdate) ;
    public List<ReservationStatusDto> getReservatrionStatuses();

    public int order(ReservationOrder reservationOrder);
}
