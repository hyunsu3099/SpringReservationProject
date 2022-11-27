/*
 * MybatisMemberDao.java
 * Mybatis 를 이용해 MemberDao 구현 (mapper.xml 내에 sql 작성)
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 */
package com.springreservation.web.dao.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springreservation.web.dao.MemberDao;
import com.springreservation.web.entity.Member;

@Repository
public class MybatisMemberDao implements MemberDao{

    private MemberDao mapper;
    @Autowired
    public MybatisMemberDao(SqlSession sqlSession) {
		mapper = sqlSession.getMapper(MemberDao.class);
	}

    @Override
    public Member findByLoginEmail(String email) {
        return mapper.findByLoginEmail(email);
    }

    @Override
    public Member findByPhoneNumber(String phone) {
        return mapper.findByPhoneNumber(phone);
    }

    @Override
    public int signup(Member member) {
        return mapper.signup(member);
    }
    
}
