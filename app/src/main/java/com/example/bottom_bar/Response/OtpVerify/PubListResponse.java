package com.example.bottom_bar.Response.OtpVerify;

import java.util.ArrayList;

public class PubListResponse {
    public int id;
    public String name;
    public String address;
    public String area;
    public String longitude;
    public String latitude;
    public String nearby;
    public String rating;
    public String review;
    public String photo;
    public String gallery;
    public String short_desc;
    public String description;
    public Object city_id;
    public Object state_id;
    public Object country_id;
    public int status;
    public Object created_at;
    public Object updated_at;
    public ArrayList<TodayTimeSlot> todayTimeSlot;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getNearby() {
        return nearby;
    }

    public void setNearby(String nearby) {
        this.nearby = nearby;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getCity_id() {
        return city_id;
    }

    public void setCity_id(Object city_id) {
        this.city_id = city_id;
    }

    public Object getState_id() {
        return state_id;
    }

    public void setState_id(Object state_id) {
        this.state_id = state_id;
    }

    public Object getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Object country_id) {
        this.country_id = country_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Object created_at) {
        this.created_at = created_at;
    }

    public Object getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Object updated_at) {
        this.updated_at = updated_at;
    }

    public ArrayList<TodayTimeSlot> getTodayTimeSlot() {
        return todayTimeSlot;
    }

    public void setTodayTimeSlot(ArrayList<TodayTimeSlot> todayTimeSlot) {
        this.todayTimeSlot = todayTimeSlot;
    }
}

