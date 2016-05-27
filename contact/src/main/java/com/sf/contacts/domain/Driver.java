package com.sf.contacts.domain;

public class Driver {
    private int imageId;

    private String name;

    private String drivinglicenseType;

    private int age;

    private int drivingExperience;

    public Driver(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getDrivinglicenseType() {
        return drivinglicenseType;
    }

    public int getAge() {
        return age;
    }

    public int getDrivingExperience() {
        return drivingExperience;
    }
}
