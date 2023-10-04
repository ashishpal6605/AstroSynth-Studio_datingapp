package com.example.bottom_bar.Request;

import com.google.gson.annotations.SerializedName;

public class SendOtpRequest {
    @SerializedName("mobile")
    String mobile;

    public SendOtpRequest(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
