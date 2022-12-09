/**
 * Reservation.java
 * 예약이름에 대한 데이터베이스 테이블 엔티티
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-7, 최종수정 2022-12-7
 */
package com.springreservation.web.entity;

public class Reservation {
    private int id;
    private String reservationName;
    private int capacity;
    private String timeOpen;
    private String timeClose;
    private String timeInterval;
    private String minimumOrder;
    public String getMinimumOrder() {
        return minimumOrder;
    }
    public void setMinimumOrder(String minimumOrder) {
        this.minimumOrder = minimumOrder;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getReservationName() {
        return reservationName;
    }
    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getTimeOpen() {
        return timeOpen;
    }
    public void setTimeOpen(String timeOpen) {
        this.timeOpen = timeOpen;
    }
    public String getTimeClose() {
        return timeClose;
    }
    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }
    public String getTimeInterval() {
        return timeInterval;
    }
    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }
}