package com.example.bottom_bar.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;
import com.example.bottom_bar.Request.ProfileRequest;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.ProfileResponse;
import com.example.bottom_bar.network.RetrofitClient;
import com.example.bottom_bar.service.Api;
import com.github.dhaval2404.imagepicker.ImagePicker;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {


    Button continuebtn;

    LinearLayout pickdate;

    TextView dateTextview;

    CircleImageView profileimg;
    ImageView pickimage;
    EditText fName,lName,email,bio;
    String Name,LastName,Email,Bio;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        continuebtn = findViewById(R.id.confirm_btn);
        pickdate = findViewById(R.id.datelayout);
        dateTextview = findViewById(R.id.selectedDateTxt);
        profileimg = findViewById(R.id.profileImage);
        pickimage = findViewById(R.id.pickimage);
        fName=findViewById(R.id.firstname);
        lName=findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        bio=findViewById(R.id.bio);

         id =getIntent().getIntExtra("id",0);



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
                Api service = RetrofitClient.getInstance().getApis();
               Name=fName.getText().toString();
               LastName=lName.getText().toString();
               Email=email.getText().toString();
               Bio=bio.getText().toString();

                ProfileRequest request=new ProfileRequest();
                request.setFirstname(Name);
                request.setLast_name(LastName);
                request.setEmail(Email);
                request.setGender("male");
                Log.d("", "onClick: "+request.getEmail()+request.getFirstname()+request.getLast_name());
                Call<BaseResponse<ProfileResponse>> call = service.updateProfile(request,id);

                call.enqueue(new Callback<BaseResponse<ProfileResponse>>() {
                    @Override
                    public void onResponse(Call<BaseResponse<ProfileResponse>> call, Response<BaseResponse<ProfileResponse>> response) {

                        Log.d("The Update profile is done", "onResponse: "+response.raw().request().url());
                        if (response.isSuccessful()){
                            Log.d("The Update profile is done", "onResponse: ");
                        }
                        else{
                            Log.d("The Update profile is failed", "onResponse: "+response.message());
                        }

                        Toast.makeText(ProfileActivity.this, "Profile is Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                    }

                    @Override
                    public void onFailure(Call<BaseResponse<ProfileResponse>> call, Throwable t) {
                        Log.d("The Update profile is failure", "onResponse: "+t.getLocalizedMessage());
                    }
                });
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