package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;

public class FriendsActivity extends AppCompatActivity {

    Button searchfrieds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);


        searchfrieds = findViewById(R.id.search);

        searchfrieds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intend = new Intent(FriendsActivity.this, MainActivity.class);
                startActivity(intend);

            }
        });
    }
}