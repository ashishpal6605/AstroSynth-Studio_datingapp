package com.example.bottom_bar.Request;

import com.google.gson.annotations.SerializedName;

public class SendEmailOtpRequest {
    @SerializedName("email")
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SendEmailOtpRequest(String email) {
        this.email = email;
    }
}
