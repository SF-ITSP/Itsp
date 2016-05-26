package com.sf.contacts.domain;

import java.util.Date;

public class Requirement {
    private Date startDate;
    private Date endDate;
    private String vehicleModel;
    private int capacityWeight;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public int getCapacityWeight() {
        return capacityWeight;
    }
}
