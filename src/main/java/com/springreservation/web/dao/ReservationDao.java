package com.springreservation.web.dao;

import java.util.List;

import com.springreservation.web.entity.OrderView;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationOrder;
import com.springreservation.web.entity.ReservationTime;

public interface ReservationDao {

    public List<Reservation> getReservationNames();

    public List<ReservationTime> getReservationTimes(int reservationId);
    
    public List<OrderView> getOrders(String startdate, String enddate, int reservationId);

    public int insertOrderDetail(ReservationOrder reservationOrder);

    public int insertOrderTime(ReservationOrder reservationOrder);
}
