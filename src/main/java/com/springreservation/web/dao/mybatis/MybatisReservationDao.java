package com.springreservation.web.dao.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springreservation.web.dao.ReservationDao;
import com.springreservation.web.entity.OrderView;
import com.springreservation.web.entity.Reservation;
import com.springreservation.web.entity.ReservationOrder;
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
    public List<ReservationTime> getReservationTimes(int reservationId){
        return mapper.getReservationTimes(reservationId);
    }

    @Override
    public List<OrderView> getOrders(String startdate, String enddate, int reservationId){
        return mapper.getOrders(startdate, enddate,reservationId);
    }

    //orderid(int)형 반환
    @Override
    public int insertOrderDetail(ReservationOrder reservationOrder) {
        return mapper.insertOrderDetail(reservationOrder);
    }
    
    @Override
    public int insertOrderTime(ReservationOrder reservationOrder) {
        return mapper.insertOrderTime(reservationOrder);
    }
}
