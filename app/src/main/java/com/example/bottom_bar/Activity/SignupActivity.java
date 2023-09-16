package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;

public class SignupActivity extends AppCompatActivity {

    Button emailLogin, phonenoLogin;
    ImageView fblogin, googlelogin, applelogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        phonenoLogin = findViewById(R.id.number_login);

        phonenoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MobilenoActivity.class);
                startActivity(intent);
            }
        });
    }
}