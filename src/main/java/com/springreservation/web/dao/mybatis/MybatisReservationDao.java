package com.springreservation.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.entity.Reservation;

@Repository
public class MybatisReservationDao implements ReservationDao {

    private ReservationDao mapper;
    @Autowired
    MybatisReservationDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(ReservationDao.class);
	}

    @Override
    public List<Reservation> getReservationList(String startdate, String enddate) {
        return mapper.getReservationList(startdate, enddate);
    }
}
