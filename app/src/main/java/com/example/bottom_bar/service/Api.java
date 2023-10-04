package com.example.bottom_bar.service;

import com.example.bottom_bar.Request.ProfileRequest;
import com.example.bottom_bar.Request.SaveInterestRequest;
import com.example.bottom_bar.Request.SendOtpRequest;
import com.example.bottom_bar.Request.VerifyOtpRequest;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.InterestListResponse;
import com.example.bottom_bar.Response.OtpVerify.PubListResponse;
import com.example.bottom_bar.Response.OtpVerify.Users;
import com.example.bottom_bar.Response.ProfileResponse;
import com.example.bottom_bar.Response.SendOtpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("send-otp")
    Call<BaseResponse<SendOtpResponse>> sendOtp(@Body SendOtpRequest sendOtpRequest);

    @POST("verify-otp")
    Call<BaseResponse<Users>> verifyOtp(@Body VerifyOtpRequest verifyOtpRequest);

    @POST("profileUpdate/{id}")
    Call<BaseResponse<ProfileResponse>> updateProfile(@Body ProfileRequest profileRequest, @Path("id") int id);

    @GET("pub/list")
    Call<BaseResponse<List<PubListResponse>>> getPubList();

    @GET("interest/list")
    Call<BaseResponse<List<InterestListResponse>>> getUserInterestList();

    @GET("saveUserInterests/{id}")
    Call<BaseResponse<List<InterestListResponse>>>  saveUserInterest(@Body SaveInterestRequest saveInterestRequest ,@Path("id") int id);

}
