/**
 * ReservationStatusDto.java
 * 해당 날짜에 예약이 가능한지를 보여주기 위한 데이터 전송 
 * 
 * 작성자 : 이현수 yzhs.go@gmail.com
 * 작성일 : 2022-11-28, 최종수정 2022-12-7
 */
package com.springreservation.web.dto;

public class ReservationStatusDto {
    private String reservationDate;
    private String reservationRoom;
    private int status; //0:예약마감 1:예약임박 2예약가능
    private boolean statusAt9; //9시 예약가능?
    private boolean statusAt12; //12시 예약가능?
    private boolean statusAt15; //15시 예약가능?
    private boolean statusAt18;//18시 예약가능?
    @Override
    public String toString() {
        return "ReservationStatusDto [reservationDate=" + reservationDate + ", reservationRoom=" + reservationRoom
                + ", status=" + status + ", statusAt9=" + statusAt9 + ", statusAt12=" + statusAt12 + ", statusAt15="
                + statusAt15 + ", statusAt18=" + statusAt18 + "]";
    }
    public ReservationStatusDto(){
        this.status=2;
        this.statusAt9=true;
        this.statusAt12=true;
        this.statusAt15=true;
        this.statusAt18=true;
    }
    public ReservationStatusDto(String reservationDate, String reservationRoom, int status, boolean statusAt9,
            boolean statusAt12, boolean statusAt15, boolean statusAt18) {
        this.reservationDate = reservationDate;
        this.reservationRoom = reservationRoom;
        this.status = status;
        this.statusAt9 = statusAt9;
        this.statusAt12 = statusAt12;
        this.statusAt15 = statusAt15;
        this.statusAt18 = statusAt18;
    }
    public String getReservationDate() {
        return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }
    public String getReservationRoom() {
        return reservationRoom;
    }
    public void setReservationRoom(String reservationRoom) {
        this.reservationRoom = reservationRoom;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public boolean isStatusAt9() {
        return statusAt9;
    }
    public void setStatusAt9(boolean statusAt9) {
        this.statusAt9 = statusAt9;solveStatus();
    }
    public boolean isStatusAt12() {
        return statusAt12;
    }
    public void setStatusAt12(boolean statusAt12) {
        this.statusAt12 = statusAt12;solveStatus();
    }
    public boolean isStatusAt15() {
        return statusAt15;
    }
    public void setStatusAt15(boolean statusAt15) {
        this.statusAt15 = statusAt15;solveStatus();
    }
    public boolean isStatusAt18() {
        return statusAt18;
    }
    public void setStatusAt18(boolean statusAt18) {
        this.statusAt18 = statusAt18;solveStatus();
    }



    private void solveStatus(){
        int temp=0;
        if(this.isStatusAt9())temp+=1;
        if(this.isStatusAt12())temp+=1;
        if(this.isStatusAt15())temp+=1;
        if(this.isStatusAt18())temp+=1;
        if(temp==1) this.status=1;
        else if(temp==0) this.status=0;
    }
}
