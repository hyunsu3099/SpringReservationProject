/*
 * MemberDao.java
 * 로그인 및 회원가입 DAO 작성을 위한 interface 지시서
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */
package com.springreservation.web.dao;

import com.springreservation.web.entity.Member;

public interface MemberDao {
    public Member findByLoginEmail(String email);
    public Member findByPhoneNumber(String phone);
    public int signup(Member member);
}
