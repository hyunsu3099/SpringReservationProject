/**
 * OrderView.java
 * 예약주문 정보를 담은 엔티티
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-6, 최종수정 2022-12-7
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
}
