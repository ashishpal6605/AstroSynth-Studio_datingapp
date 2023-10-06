package com.example.bottom_bar.Request;

import com.google.gson.annotations.SerializedName;

public class VerifyEmailOtpRequest {
    @SerializedName("email")
     String email;

    @SerializedName("otp")
    int otp;

    public VerifyEmailOtpRequest(String email, int otp) {
        this.email = email;
        this.otp = otp;
    }
}
