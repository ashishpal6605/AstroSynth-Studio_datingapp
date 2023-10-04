package com.example.bottom_bar.Request;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class ProfileRequest {
    @SerializedName("firstname")
    String firstname;
    @SerializedName("last_name")
    String last_name;
    @SerializedName("email")
    String email;
    @SerializedName("dob")
    Date date;
    @SerializedName("gender")
    String gender;
    @SerializedName("profilePic")
    String profilePic;
    @SerializedName("profile_pending")
    int profile_pending;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public int getProfile_pending() {
        return profile_pending;
    }

    public void setProfile_pending(int profile_pending) {
        this.profile_pending = profile_pending;
    }
}
