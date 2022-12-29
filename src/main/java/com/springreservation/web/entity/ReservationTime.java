package com.springreservation.web.entity;

import com.springreservation.web.dto.ReservationStatusDto;

public class ReservationTime {
    private String timeStart;
    private boolean enabledYn = true;
    public String getTimeStart() {
        return timeStart;
    }
    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }
    public boolean isEnabledYn() {
        return enabledYn;
    }
    public void setEnabledYn(boolean enabledYn) {
        this.enabledYn = enabledYn;
    }

    public ReservationStatusDto getReservationStatusDto(){
        ReservationStatusDto dto = new ReservationStatusDto();
        dto.setReservationTime(timeStart);
        return dto;
    }
}
