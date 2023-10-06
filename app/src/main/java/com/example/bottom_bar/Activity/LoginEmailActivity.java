package com.example.bottom_bar.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bottom_bar.R;
import com.example.bottom_bar.Request.SendEmailOtpRequest;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.SendOtpResponse;
import com.example.bottom_bar.network.RetrofitClient;
import com.example.bottom_bar.service.Api;
import com.example.bottom_bar.utils.SessionManager;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LoginEmailActivity extends AppCompatActivity {
TextInputLayout email,password;
Button loginButton;
    String Email,Password;
    SessionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_password);
        loginButton=findViewById(R.id.continue_button);
        manager=new SessionManager(this);



          //  Password=email.getEditText().getText().toString();

//            if (TextUtils.isEmpty(Email)) {
//                Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
//                return;
//            }
//            if (TextUtils.isEmpty(Password)) {
//                Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
//                return;
//            }




        loginButton.setOnClickListener(v->{
            Email=email.getEditText().getText().toString();
            manager.setEmail(Email);
            if (Email.isEmpty()){
                Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show();
            }
            else {
                Log.d("on api si get calling", "onCreate: "+Email);
                Api service= RetrofitClient.getInstance().getApis();
                Call<BaseResponse<SendOtpResponse>> call=service.sendEmailOtp(new SendEmailOtpRequest(Email));

                call.enqueue(new Callback<BaseResponse<SendOtpResponse>>() {

                    @Override
                    public void onResponse(Call<BaseResponse<SendOtpResponse>> call, Response<BaseResponse<SendOtpResponse>> response) {
                        Log.d("", "onResponse: "+response.raw().request().url());
                        if (response.isSuccessful()){
                            Intent intent=new Intent(LoginEmailActivity.this,OtpActivity.class);
                            String otp= String.valueOf(response.body().getData().getTestOtp());
                            intent.putExtra("otp",otp);
                            intent.putExtra("number",100);
                            startActivity(intent);
                            Log.d("Send Email otp done", "onResponse: "+response.body().getData().getTestOtp());
                        }
                        else
                            Log.d("Send Email otp Failed", "onResponse: "+response.errorBody());
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<SendOtpResponse>> call, Throwable t) {
                        Log.d("Send Email otp failure", "onResponse: "+t.getLocalizedMessage());
                    }
                });
            }

        });

    }


}