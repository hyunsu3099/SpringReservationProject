package com.springreservation.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.entity.Reservation;

@Service
public class ReservationServiceImp implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public List<Reservation> getReservationList(String startdate) {
        // 마지막날짜 생성
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		Date nowdate;
		try {
            nowdate = formatter.parse(startdate);
        } catch (ParseException e) {
            nowdate=new Date();
            startdate = formatter.format(nowdate);
        }
		Calendar cal = Calendar.getInstance();
        cal.setTime(nowdate);
		cal.add(Calendar.DATE, 5);
		String enddate = formatter.format(cal.getTime());

        return getReservationList(startdate,enddate);
    }

    @Override
    public List<Reservation> getReservationList() {
        // 오늘 날짜를 생성한 후 dao.getReservationList(startdate)호출
        Date nowdate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String startdate = formatter.format(nowdate);
		Calendar cal = Calendar.getInstance();
        cal.setTime(nowdate);
		cal.add(Calendar.DATE, 5);
		String enddate = formatter.format(cal.getTime());

        return getReservationList(startdate, enddate);
    }

    @Override
    public List<Reservation> getReservationList(String startdate, String enddate) {
        return reservationDao.getReservationList(startdate,enddate);
    }
}
