/*
 * MemberServiceImp.java
 * 로그인 및 회원가입을 위한 데이터베이스 입력 및 요청
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */
package com.springreservation.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.MemberDao;
import com.springreservation.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService{
    
    @Autowired
    private MemberDao memberDao;

    @Override
    public String findPwByLoginEmail(String email) {
        return memberDao.findByLoginEmail(email).getEncodedPw();
    }

    @Override
    public String findPwByPhoneNumber(String phone) {
        return memberDao.findByPhoneNumber(phone).getEncodedPw();
    }

    @Override
    public Member findInfoByLoginEmail(String email) {
        return memberDao.findByLoginEmail(email);
    }

    @Override
    public Member findInfoByPhoneNumber(String phone) {
        return memberDao.findByPhoneNumber(phone);
    }

    @Override
    public int signup(Member member) {
        return memberDao.signup(member);
    }

    @Override
    public boolean emailExists(String email) {
        return memberDao.findByLoginEmail(email)!=null;
    }

    @Override
    public boolean phoneExists(String phone) {
        return memberDao.findByPhoneNumber(phone)!=null;
    }
}
