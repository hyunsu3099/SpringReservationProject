/**
 * ReservationServoviceImp.java
 * 예약데이터 처리를 위한 서비스 구현
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-7
 */
package com.springreservation.web.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationTime;

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

    @Override
    public List<Reservation> getReservationNames() {
        return reservationDao.getReservationNames();
    }

    @Override
    public List<ReservationTime> getReservationTimes(String startdate, String enddate, int reservationId) {

        List<ReservationTime> list = reservationDao.getReservedTimes(startdate,enddate,reservationId);
        List<ReservationTime> list2 = reservationDao.getReservationTimes(reservationId);

        Set<String> set = new HashSet<>();
        for(ReservationTime time : list) set.add(time.getStartTime());



        return list;
    }

    @Override
    public List<ReservationTime> getReservationTimes(String startdate, int reservationId) {
        return getReservationTimes(startdate,startdate,reservationId);
    }
}
