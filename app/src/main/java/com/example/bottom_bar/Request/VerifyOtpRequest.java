package com.example.bottom_bar.Request;

import com.google.gson.annotations.SerializedName;

public class VerifyOtpRequest {
    @SerializedName("mobile")
    String mobile;
    @SerializedName("otp")
    int otp;

    public VerifyOtpRequest(String mobile, int otp) {
        this.mobile = mobile;
        this.otp = otp;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }
}

