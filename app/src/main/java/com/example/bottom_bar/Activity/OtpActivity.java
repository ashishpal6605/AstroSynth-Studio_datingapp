package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;

public class OtpActivity extends AppCompatActivity {
    Button submitbutton;
    private EditText otp1, otp2, otp3, otp4, otp5, otp6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp1 = findViewById(R.id.pin1);
        otp2 = findViewById(R.id.pin2);
        otp3 = findViewById(R.id.pin3);
        otp4 = findViewById(R.id.pin4);
        otp5 = findViewById(R.id.pin5);
        otp6 = findViewById(R.id.pin6);
        submitbutton = findViewById(R.id.btnContinue);


        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OtpActivity.this, ProfileActivity.class);
                startActivity(i);
            }
        });

        // Add TextWatchers for OTP fields
        setOtpTextWatcher(otp1, otp2);
        setOtpTextWatcher(otp2, otp3);
        setOtpTextWatcher(otp3, otp4);
        setOtpTextWatcher(otp4, otp5);
        setOtpTextWatcher(otp5, otp6);
        setOtpTextWatcher(otp6, null);


        // Handle the Enter key press on the last OTP field
        otp6.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                // Handle OTP submission here
                return actionId == EditorInfo.IME_ACTION_DONE; // Consume the event
// Let the system handle the event
            }
        });

        // Handle the Back key press to navigate between OTP fields
        // Handle the Back key press to navigate between OTP fields and clear the current field
        otp1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
                    // Clear the current field and set focus
                    otp1.setText("");
                    otp1.requestFocus();
                    return true; // Consume the event
                }
                return false; // Let the system handle the event
            }
        });
    }

    private void setOtpTextWatcher(final EditText currentEditText, final EditText nextEditText) {
        currentEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() == 1) {
                    // Change the background color
                    currentEditText.setBackgroundResource(R.drawable.otp_box_filled_bg);
                    if (nextEditText != null) {
                        nextEditText.requestFocus();
                    }
                } else {
                    // Revert to the default background color if empty
                    currentEditText.setBackgroundResource(R.drawable.otp_box_empty_bg);
                }
            }
        });
    }
}