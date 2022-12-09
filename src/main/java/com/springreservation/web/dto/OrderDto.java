/**
 * OrderDto.java
 * 예약주문 전달 객체
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-12-6, 최종수정 2022-12-6
 */
package com.springreservation.web.dto;

public class OrderDto {
    private String reservationId;
    private String reservationDate;
    private String timeStart;
    private String timeEnd;
    private boolean enabledYn;
}
