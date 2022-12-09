package com.springreservation.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationTime;

@Repository
public class MybatisReservationDao implements ReservationDao {

    private ReservationDao mapper;
    @Autowired
    MybatisReservationDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(ReservationDao.class);
	}
    //예약 이름 및 정보를 가져옴
    @Override
    public List<Reservation> getReservationNames() {
        return mapper.getReservationNames();
    }

    @Override
    public List<Reservation> getReservationList(String startdate, String enddate) {
        return mapper.getReservationList(startdate, enddate);
    }

    @Override
    public List<ReservationTime> getReservationTimes(int reservationId){
        return mapper.getReservationTimes(reservationId);
    }

    @Override
    public List<ReservationTime> getReservedTimes(String startdate, String enddate, int reservationId){
        return mapper.getReservedTimes(startdate, enddate,reservationId);
    }

}
