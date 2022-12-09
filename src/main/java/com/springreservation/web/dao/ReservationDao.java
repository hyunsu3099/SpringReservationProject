package com.springreservation.web.dao;

import java.util.List;

import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationTime;

public interface ReservationDao {
    public List<Reservation> getReservationList(String startdate,String enddate);

    public List<Reservation> getReservationNames();

    public List<ReservationTime> getReservationTimes(int reservationId);
    public List<ReservationTime> getReservedTimes(String startdate, String enddate, int reservationId);
}
