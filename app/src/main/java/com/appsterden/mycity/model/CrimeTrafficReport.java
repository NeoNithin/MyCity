package com.appsterden.mycity.model;

/**
 * Created by Nithin on 10/5/2015.
 */
public class CrimeTrafficReport {
    private String incedent;
    private String date;
    private String time;
    private Double lng;
    private Double lat;
    private String place;
    private String Description;

    public String getIncedent() {
        return incedent;
    }

    public void setIncedent(String incedent) {
        this.incedent = incedent;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
