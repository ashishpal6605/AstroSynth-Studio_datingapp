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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bottom_bar.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class OtpActivity extends AppCompatActivity {
    Button submitbutton;
    private EditText otp1, otp2, otp3, otp4, otp5, otp6;
    String phoneNumber;
    TextView resendOtp;
    String otpId;
    FirebaseAuth auth;
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
        resendOtp = findViewById(R.id.resend_otp);
        auth=FirebaseAuth.getInstance();
        submitbutton = findViewById(R.id.btnContinue);
        phoneNumber=getIntent().getStringExtra("mobile").toString();




        // Add TextWatchers for OTP fields
        setOtpTextWatcher(otp1, otp2);
        setOtpTextWatcher(otp2, otp3);
        setOtpTextWatcher(otp3, otp4);
        setOtpTextWatcher(otp4, otp5);
        setOtpTextWatcher(otp5, otp6);
        setOtpTextWatcher(otp6, null);

        initiateOtp();


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


        submitbutton.setOnClickListener(v -> {
            if (otp1.getText().toString().isEmpty()&&otp2.getText().toString().isEmpty()&&otp3.getText().toString().isEmpty()
                    &&otp4.getText().toString().isEmpty()&&otp5.getText().toString().isEmpty()&&otp6.getText().toString().isEmpty()){
                Toast.makeText(OtpActivity.this, "Blank Field can not be processed", Toast.LENGTH_SHORT).show();
            } else {
                String otpField=otp1.getText().toString()+otp2.getText().toString()+otp3.getText().toString()+otp4.getText().toString()+otp5.getText().toString()+otp6.getText().toString();
                PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpId,otpField);
                signInWithPhoneAuthCredential(credential);
            }
//                Intent i = new Intent(OtpActivity.this, ProfileActivity.class);
//                startActivity(i);
        });
        resendOtp.setOnClickListener(v->{
            startActivity(new Intent(this,MainActivity.class));
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

    private void initiateOtp(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phoneNumber, 60, TimeUnit.SECONDS, this,
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                         otpId=s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                      signInWithPhoneAuthCredential(phoneAuthCredential);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(OtpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        auth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                      if (task.isSuccessful()){
                          startActivity(new Intent(OtpActivity.this,MainActivity.class));
                          finish();
                      }else {
                          Toast.makeText(OtpActivity.this, "SignIn Code Error", Toast.LENGTH_SHORT).show();
                      }
                    }
                });
    }
}