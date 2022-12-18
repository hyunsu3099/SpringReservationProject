/**
 * OrderView.java
 * 예약주문 정보를 담은 엔티티
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-6, 최종수정 2022-12-15
 */
package com.springreservation.web.entity;

import java.util.Date;

public class OrderView {
    private int id;
    private int memberId;
    private String memberName;
    private String memberEmail;
    private String memberPhone;
    private int reservationId;
    private String reservationName;
    private Date reservationDate;
    private String timeStart;
    private String timeEnd;
    private boolean enabledYn;
    private boolean expiredYn;
    private Date regDate;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public String getMemberEmail() {
        return memberEmail;
    }
    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }
    public String getMemberPhone() {
        return memberPhone;
    }
    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }
    public int getReservationId() {
        return reservationId;
    }
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
    public String getReservationName() {
        return reservationName;
    }
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }
    public Date getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    public String getTimeEnd() {
        return timeEnd;
    }
    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
    public boolean isEnabledYn() {
        return enabledYn;
    }
    public void setEnabledYn(boolean enabledYn) {
        this.enabledYn = enabledYn;
    }
    public boolean isExpiredYn() {
        return expiredYn;
    }
    public void setExpiredYn(boolean expiredYn) {
        this.expiredYn = expiredYn;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
}
