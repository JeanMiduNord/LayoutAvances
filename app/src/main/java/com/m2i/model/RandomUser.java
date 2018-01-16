package com.m2i.model;

/**
 * Created by Formation on 16/01/2018.
 */

public class RandomUser {
    private String userName;
    private String email;
    private Double latitude;
    private Double longitude;

    @Override
    public String toString() {
        return this.userName;
    }

    public RandomUser() {
    }

    public String getUserName() {
        return userName;
    }

    public RandomUser setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public RandomUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public Double getLatitude() {
        return latitude;
    }

    public RandomUser setLatitude(Double latitude) {
        this.latitude = latitude;
        return this;
    }

    public Double getLongitude() {
        return longitude;
    }

    public RandomUser setLongitude(Double longitude) {
        this.longitude = longitude;
        return this;
    }
}
