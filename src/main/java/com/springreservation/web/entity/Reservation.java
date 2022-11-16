package com.springreservation.web.entity;

import java.util.Date;

public class Reservation {
    private String memberName;
    private Date regDate;
    private String reservationId;
    private String reservationDate;
    private String reservationTime;
    private String reservationRoom;
    private boolean reservationYn;
    public String getMemberName() {
        return memberName;
    }
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }
    public Date getRegDate() {
        return regDate;
    }
    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }
    public String getReservationId() {
        return reservationId;
    }
    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getReservationTime() {
        return reservationTime;
    }
    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }
    public String getReservationRoom() {
        return reservationRoom;
    }
    public void setReservationRoom(String reservationRoom) {
        this.reservationRoom = reservationRoom;
    }
    public boolean isReservationYn() {
        return reservationYn;
    }
    public void setReservationYn(boolean reservationYn) {
        this.reservationYn = reservationYn;
    }
    @Override
    public String toString() {
        return "Reservation [memberName=" + memberName + ", regDate=" + regDate + ", reservationId=" + reservationId
                + ", reservationDate=" + reservationDate + ", reservationTime=" + reservationTime + ", reservationRoom="
                + reservationRoom + ", reservationYn=" + reservationYn + "]";
    }
    public Reservation(String memberName, Date regDate, String reservationId, String reservationDate,
            String reservationTime, String reservationRoom, boolean reservationYn) {
        this.memberName = memberName;
        this.regDate = regDate;
        this.reservationId = reservationId;
        this.reservationDate = reservationDate;
        this.reservationTime = reservationTime;
        this.reservationRoom = reservationRoom;
        this.reservationYn = reservationYn;
    }
    public Reservation(){}
}