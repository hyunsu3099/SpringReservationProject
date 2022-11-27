/*
 * MemberServiceImp.java
 * 로그인 및 회원가입을 위한 데이터베이스 입력 및 요청
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */
package com.springreservation.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springreservation.web.dao.MemberDao;
import com.springreservation.web.entity.Member;

@Service
public class MemberServiceImp implements MemberService{
    
    @Autowired
    private BCryptPasswordEncoder bEncoder;

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
    public Member loginByEmail(String email, String pw) {
        //id 조회안될시 null 반환
        Member member = memberDao.findByLoginEmail(email);
        if(member == null) return null;
        //pw 일치하면, member 반환
        if(bEncoder.matches(pw, member.getEncodedPw()) ) return member;
        //pw 일치하지 않으면, 빈 member 객체 반환
        else{
            member = new Member();
            member.setPhone(email);
            return member;
        }
    }

    @Override
    public Member loginByPhoneNumber(String phone , String pw) {
        //id 조회안될시 null 반환
        Member member = memberDao.findByPhoneNumber(phone);
        if(member == null) return null;
        //pw 일치하면, member 반환
        if(bEncoder.matches(pw, member.getEncodedPw())) return member;
        //pw 일치하지 않으면, 빈 member 객체 반환
        else{
            member = new Member();
            member.setPhone(phone);
            return member;
        } 
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
