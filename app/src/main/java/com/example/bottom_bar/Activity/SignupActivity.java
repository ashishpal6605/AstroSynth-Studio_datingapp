package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;
import com.example.bottom_bar.Request.SendOtpRequest;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.SendOtpResponse;
import com.example.bottom_bar.network.RetrofitClient;
import com.example.bottom_bar.service.Api;
import com.hbb20.CountryCodePicker;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    Button continues;
    ImageView fblogin, googlelogin, applelogin;
    CountryCodePicker ccp;
    EditText editText;
   String number;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        continues = findViewById(R.id.continuebtn);
        editText = findViewById(R.id.etPhoneNo);
        ccp = findViewById(R.id.country_code);
        googlelogin=findViewById(R.id.googlelogin);
        fblogin=findViewById(R.id.fblogin);

        ccp.registerCarrierNumberEditText(editText);

        googlelogin.setOnClickListener(v->{
            startActivity(new Intent(this,MainActivity.class));
        });

        fblogin.setOnClickListener(v->{
            startActivity(new Intent(this ,PassionsActivity.class));
        });

        continues.setOnClickListener(v -> {
            Api service= RetrofitClient.getInstance().getApis();
             number=editText.getText().toString();
            Log.d("The actual number is", "onCreate: "+number);
            Call<BaseResponse<SendOtpResponse>> data =service.sendOtp(new SendOtpRequest(number));

            data.enqueue(new Callback<BaseResponse<SendOtpResponse>>() {
                @Override
                public void onResponse(Call<BaseResponse<SendOtpResponse>> call, Response<BaseResponse<SendOtpResponse>> response) {
                    Log.d("The Url is", "onResponse: "+response.raw().request().url());

                    if (response.isSuccessful()){
                        Log.d("Send Otp Success", "onResponse: "+response.body().getData().getTestOtp());
                        Toast.makeText(SignupActivity.this, "Your OTP IS it +will be automatically updated just click on continue "+response.body().getData().getTestOtp(), Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(SignupActivity.this, OtpActivity.class);
                        intent.putExtra("mobile",number);
                        String otp= String.valueOf(response.body().getData().getTestOtp());
                        intent.putExtra("otp",otp);
                        startActivity(intent);

                    }
                    else {
                        Log.d("Send Otp Failed", "onResponse: ");
                    }
                }

                @Override
                public void onFailure(Call<BaseResponse<SendOtpResponse>> call, Throwable t) {
                    Log.d("Send Otp Failure", "onFailure: ");
                }
            });


        });


    }
}

