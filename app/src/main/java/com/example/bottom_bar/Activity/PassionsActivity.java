package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;

public class PassionsActivity extends AppCompatActivity {

    TextView skip, photography, shopping, karaoke, yoga, cooking, tennis, run, swimming, art, travelling, extreme, music, drink, videogames;
    Button continuebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passions);

        skip = findViewById(R.id.skip);
        photography = findViewById(R.id.photopraphytxt);
        shopping = findViewById(R.id.shoppingtxt);
        karaoke = findViewById(R.id.karaoketxt);
        yoga = findViewById(R.id.yoga);
        cooking = findViewById(R.id.cookingtxt);
        tennis = findViewById(R.id.tennistxt);
        run = findViewById(R.id.runtxt);
        swimming = findViewById(R.id.swimmingtxt);
        art = findViewById(R.id.arttxt);
        travelling = findViewById(R.id.travelingtxt);
        extreme = findViewById(R.id.extremetxt);
        music = findViewById(R.id.musictxt);
        drink = findViewById(R.id.drinktxt);
        videogames = findViewById(R.id.videogametxt);
        continuebutton = findViewById(R.id.continuebtn);


        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(PassionsActivity.this, HomePage.class);
                startActivity(in);
            }
        });

        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(PassionsActivity.this, HomePage.class);
                startActivity(in);
            }
        });


    }
}