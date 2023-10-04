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


public class RegisterActivity extends AppCompatActivity {
TextInputLayout email,password;
Button registerButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=findViewById(R.id.register_email);
        password=findViewById(R.id.register_password);
        registerButton=findViewById(R.id.registerbtn);



        registerButton.setOnClickListener(v->{
            registerNewUser();
        });

    }

    private void registerNewUser() {

        String Email, Password;
        Email = email.getEditText().getText().toString();
        Password = password.getEditText().getText().toString();

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