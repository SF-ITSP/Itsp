package com.sf.contacts.domain;

public class Driver {
    private long id;
    private int age;
    private int imageId;
    private int drivingExperience;

    private String name;
    private String drivingLicenseType;

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDrivingLicenseType() {
        return drivingLicenseType;
    }

    public int getAge() {
        return age;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }

    public long getId() {
        return id;
    }
}
