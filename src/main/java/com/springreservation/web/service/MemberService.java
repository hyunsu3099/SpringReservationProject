/*
 * MemberService.java
 * 로그인 서비스 작성을 위한 interface 지시서
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */
package com.springreservation.web.service;

import com.springreservation.web.entity.Member;

public interface MemberService {

    public boolean emailExists(String email);
    public boolean phoneExists(String phone);
    
    public String findPwByLoginEmail(String email);
    public String findPwByPhoneNumber(String phone);

    public Member findInfoByLoginEmail(String email);
    public Member findInfoByPhoneNumber(String phone);
    public int signup(Member member);

}
