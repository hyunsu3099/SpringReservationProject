package com.springreservation.web.service;

import java.util.List;

import com.springreservation.web.entity.Reservation;

public interface ReservationService {
    public List<Reservation> getReservationList(String startdate, String enddate);
    public List<Reservation> getReservationList(String startdate);
    public List<Reservation> getReservationList();
}
