package com.example.bottom_bar.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;
import com.github.dhaval2404.imagepicker.ImagePicker;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {


    Button continuebtn;

    LinearLayout pickdate;

    TextView dateTextview;

    CircleImageView profileimg;
    ImageView pickimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        continuebtn = findViewById(R.id.continuebtn);
        pickdate = findViewById(R.id.datelayout);
        dateTextview = findViewById(R.id.selectedDateTxt);
        profileimg = findViewById(R.id.profileImage);
        pickimage = findViewById(R.id.pickimage);


        pickimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(ProfileActivity.this)
                        .crop()
                        .start();

            }
        });


        continuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileActivity.this, PassionsActivity.class);
                startActivity(i);
            }
        });


        // Define the time range as an array of strings
        String[] timeRange = {"Male", "Female", "Other"};

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
//                Toast.makeText(HomeDetailPage.this, "Selected Time: " + selectedTime, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing if nothing is selected
            }
        });
    }


    public void showDatePickerDialog(View view) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // Called when the user selects a date.
                // You can update the TextView with the selected date here.
                String selectedDate = day + "/" + (month + 1) + "/" + year;
                dateTextview.setText(selectedDate);
            }
        }, 2023, 0, 1); // Initial date set to January 1, 2023

        datePickerDialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri=data.getData();
        profileimg.setImageURI(uri);
    }
}