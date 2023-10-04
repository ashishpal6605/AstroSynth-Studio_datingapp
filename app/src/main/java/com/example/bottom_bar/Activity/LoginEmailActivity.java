package com.example.bottom_bar.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bottom_bar.R;
import com.google.android.material.textfield.TextInputLayout;


public class LoginEmailActivity extends AppCompatActivity {
TextInputLayout email,password;
Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_email);
        email=findViewById(R.id.login_email);
        password=findViewById(R.id.login_email);
        loginButton=findViewById(R.id.loginbtn);

        loginButton.setOnClickListener(v->{
            loginUserAccount();
        });

    }

    private void loginUserAccount() {
        String Email,Password;
        Email=email.getEditText().getText().toString();
        Password=email.getEditText().getText().toString();

        if (TextUtils.isEmpty(Email)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(Password)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }


    }
}