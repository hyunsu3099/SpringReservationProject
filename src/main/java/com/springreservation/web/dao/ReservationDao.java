package com.springreservation.web.dao;

import java.util.List;

import com.springreservation.web.entity.Reservation;

public interface ReservationDao {
    public List<Reservation> getReservationList(String startdate,String enddate);
}
