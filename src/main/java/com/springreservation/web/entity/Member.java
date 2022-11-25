/**
 * Member.java
 * 회원정보에 대한 엔티티
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-23, 최종수정 2022-11-25
 */
package com.springreservation.web.entity;

import java.util.Date;

public class Member {
    private int id;
	private String email;
	private String name;
    private String phone; // "000-0000-0000 하이픈 포함 String"
	private String encodedPw;
    private Date regDate;
    private String role = "nonmember";
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEncodedPw() {
        return encodedPw;
    }
    public void setEncodedPw(String encodedPw) {
        this.encodedPw = encodedPw;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    @Override
    public String toString() {
        return "Member [id=" + id + ", email=" + email + ", name=" + name + ", phone=" + phone + ", encodedPw="
                + encodedPw + ", regDate=" + regDate + ", role=" + role
                + "]";
    }
}
