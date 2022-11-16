package com.springreservation.web.dto;

public class ReservationStatusDto {
    private String reservationDate;
    private String reservationRoom;
    private int status; //0:예약마감 1:예약임박 2예약가능
    private boolean statusAt9Yn=true; //9시 예약가능?
    private boolean statusAt12Yn=true; //12시 예약가능?
    private boolean statusAt15Yn=true; //15시 예약가능?
    private boolean statusAt18Yn=true;//18시 예약가능?
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
    public boolean isStatusAt9Yn() {
        return statusAt9Yn;
    }
    public void setStatusAt9Yn(boolean statusAt9Yn) {
        this.statusAt9Yn = statusAt9Yn; solveStatus();
    }
    public boolean isStatusAt12Yn() {
        return statusAt12Yn;
    }
    public void setStatusAt12Yn(boolean statusAt12Yn) {
        this.statusAt12Yn = statusAt12Yn; solveStatus();
    }
    public boolean isStatusAt15Yn() {
        return statusAt15Yn;
    }
    public void setStatusAt15Yn(boolean statusAt15Yn) {
        this.statusAt15Yn = statusAt15Yn; solveStatus();
    }
    public boolean isStatusAt18Yn() {
        return statusAt18Yn;
    }
    public void setStatusAt18Yn(boolean statusAt18Yn) {
        this.statusAt18Yn = statusAt18Yn; solveStatus();
    }
    @Override
    public String toString() {
        return "ReservationStatusDto [reservationDate=" + reservationDate + ", reservationRoom=" + reservationRoom
                + ", status=" + status + ", statusAt9Yn=" + statusAt9Yn + ", statusAt12Yn=" + statusAt12Yn
                + ", statusAt15Yn=" + statusAt15Yn + ", statusAt18Yn=" + statusAt18Yn + "]";
    }
    public ReservationStatusDto(String reservationDate, String reservationRoom, int status, boolean statusAt9Yn,
            boolean statusAt12Yn, boolean statusAt15Yn, boolean statusAt18Yn) {
        this.reservationDate = reservationDate;
        this.reservationRoom = reservationRoom;
        this.status = status;
        this.statusAt9Yn = statusAt9Yn;
        this.statusAt12Yn = statusAt12Yn;
        this.statusAt15Yn = statusAt15Yn;
        this.statusAt18Yn = statusAt18Yn;
    }
    public ReservationStatusDto(){
    }
    private void solveStatus(){
        int temp=0;
        if(this.statusAt9Yn)temp+=1;
        if(this.statusAt12Yn)temp+=1;
        if(this.statusAt15Yn)temp+=1;
        if(this.statusAt18Yn)temp+=1;
        if(temp>1) this.status=2;
        if(temp==1) this.status=1;
        if(temp==0) this.status=0;
    }
}
