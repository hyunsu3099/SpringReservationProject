/**
 * SignupDto.java
 * 회원가입 정보 전달 객체
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-23
 */
package com.springreservation.web.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springreservation.web.entity.Member;

public class SignupDto {

    private int id;
    private String pw;
    private String email;
    private String phone;
    private String name;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Member getMember(BCryptPasswordEncoder bEncoder){
        Member member =new Member();
        member.setId(id);
        member.setEncodedPw(bEncoder.encode(pw));
        member.setEmail(email);
        member.setName(name);
        member.setPhone(phone);
        member.setRole(role);
        return member;
    }

    @Override
    public String toString() {
        return "SignupDto [id=" + id + ", pw=" + pw + ", email=" + email + ", phone=" + phone + ", name=" + name
                + ", role=" + role + "]";
    }
    
}