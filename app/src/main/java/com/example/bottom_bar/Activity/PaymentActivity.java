package com.example.bottom_bar.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.bottom_bar.R;
import com.example.bottom_bar.fragment.MessegeFragment;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button btn = findViewById(R.id.payButton);


        Checkout.preload(getApplicationContext());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment();
            }
        });


    }


    private void startPayment() {

        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_eNwgA5oEnElHde");

        checkout.setImage(R.drawable.logo);
        final Activity activity = this;
        try {
            JSONObject options = new JSONObject();
            options.put("name", "MeetAtParty");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
//            options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
            options.put("amount", "74900");//pass amount in currency subunits
            options.put("prefill.email", "bhartisbsit@gmail.com");
            options.put("prefill.contact", "7687568654");
            JSONObject retryObj = new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count", 4);
            options.put("retry", retryObj);

            checkout.open(activity, options);

        } catch (Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }


    public void onPaymentSuccess(String s) {
        Log.d("ONSUCCESS", "onPaymentSuccess: " + s);

        Intent intent=  new Intent(PaymentActivity.this, MessegeFragment.class);
        startActivity(intent);

        JSONObject paymentData = new JSONObject();
        try {
            paymentData.put("status", 200);
            JSONObject data = new JSONObject();
            data.put("id", 3);
            data.put("payment_id", s);
            data.put("transaction_id", "10230003");
            data.put("amount", 749);
            data.put("month", "1");
            data.put("user_id", 1);
            data.put("subscription_id", 7);
            data.put("razorpay_status", "success");
            data.put("payment_email", "bhartisbsit@gmail.com");
            data.put("payment_contact", "7687568654");
            data.put("currency", "INR");
            data.put("created_at", "2023-10-05T02:19:00.000000Z");
            data.put("updated_at", "2023-10-05T02:19:00.000000Z");
            paymentData.put("data", data);
            paymentData.put("message", "payment details");



        } catch (JSONException e) {
            e.printStackTrace();
        }

        // Instantiate the RequestQueue
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://meetatparty.com/api/payment/paymentdetails/3"; // Replace with your server API URL

        // Create a JsonObjectRequest to send the data to your server
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, paymentData,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle the response from your server here
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle errors here
            }
        });

        // Add the request to the RequestQueue
        queue.add(jsonObjectRequest);


    }


    public void onPaymentError(int i, String s) {
        Log.d("ONERROR", "onPaymentError: " + s);
    }


}