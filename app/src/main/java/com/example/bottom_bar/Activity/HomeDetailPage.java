package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;

public class HomeDetailPage extends AppCompatActivity {
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail_page);


        btn = findViewById(R.id.postbutton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeDetailPage.this, MainActivity.class);
                startActivity(i);
            }
        });

// Define the time range as an array of strings
        String[] timeRange = {"10:00 AM - 11:00 AM", "11:00 AM-12:00 AM", "12:00 PM-01:00 PM", "01:00 PM-02:00 PM", "02:00 PM-03:00 PM", "03:00 PM-04:00 PM"};

        // Initialize the Spinner
        Spinner timeSpinner = findViewById(R.id.timeSpinner);

        // Create an ArrayAdapter and set it to the Spinner
        ArrayAdapter<String> timeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, timeRange);
        timeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeSpinner.setAdapter(timeAdapter);

        // Set an item selection listener for the Spinner
        timeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Handle the selected time here
                String selectedTime = timeRange[position];
                Toast.makeText(HomeDetailPage.this, "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing if nothing is selected
            }
        });
    }
}