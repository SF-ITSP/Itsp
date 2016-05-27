package com.sf.contacts.domain;

import java.util.Date;

public class Requirement {
    private long id;

    private Date startDate;

    private Date endDate;

    private String vehicleType;

    private int capacityWeight;

    private long carrierId;

    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacityWeight() {
        return capacityWeight;
    }

    public void setCapacityWeight(int capacityWeight) {
        this.capacityWeight = capacityWeight;
    }

    public long getCarrierId() {
        return carrierId;
    }

    public void setCarrierId(long carrierId) {
        this.carrierId = carrierId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
