package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;
import com.hbb20.CountryCodePicker;

public class SignupActivity extends AppCompatActivity {

    Button continues;
    ImageView fblogin, googlelogin, applelogin;
    CountryCodePicker ccp;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        continues = findViewById(R.id.continuebtn);
        editText = findViewById(R.id.etPhoneNo);
        googlelogin = findViewById(R.id.googlelogin);
        ccp = findViewById(R.id.country_code);

        ccp.registerCarrierNumberEditText(editText);
        continues.setOnClickListener(v -> {
            Intent intent = new Intent(SignupActivity.this, OtpActivity.class);
            intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
            startActivity(intent);
        });

        googlelogin.setOnClickListener(v->{
            startActivity(new Intent(this,RegisterActivity.class));
        });
    }
}