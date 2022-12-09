package com.springreservation.web.entity;

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
}
