package com.springreservation.web.entity;

import com.springreservation.web.dto.ReservationStatusDto;

public class ReservationTime {
    private String startTime;
    private boolean enabledYn = true;
    public String getStartTime() {
        return startTime;
    }
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    public boolean isEnabledYn() {
        return enabledYn;
    }
    public void setEnabledYn(boolean enabledYn) {
        this.enabledYn = enabledYn;
    }

    public ReservationStatusDto getReservationStatusDto(){
        ReservationStatusDto dto = new ReservationStatusDto();
        dto.setReservationTime(startTime);
        return dto;
    }
}
