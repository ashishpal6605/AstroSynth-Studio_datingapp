package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.bottom_bar.Adapter.InterestAdapter;
import com.example.bottom_bar.R;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.InterestListResponse;
import com.example.bottom_bar.network.RetrofitClient;
import com.example.bottom_bar.service.Api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PassionsActivity extends AppCompatActivity {

//    TextView skip, photography, shopping, karaoke, yoga, cooking, tennis, run, swimming, art, travelling, extreme, music, drink, videogames;
    Button continuebutton;
    List<InterestListResponse> list;
    RecyclerView recyclerView;
    InterestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passions);





   recyclerView=findViewById(R.id.interest_rv);
        list=new ArrayList<>();
        adapter=new InterestAdapter(list,PassionsActivity.this);

        Api service= RetrofitClient.getInstance().getApis();
        Call<BaseResponse<List<InterestListResponse>>> call=service.getUserInterestList();

        call.enqueue(new Callback<BaseResponse<List<InterestListResponse>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<InterestListResponse>>> call, Response<BaseResponse<List<InterestListResponse>>> response) {
                if (response.isSuccessful()){
                      list=response.body().getData();
                       adapter=new InterestAdapter(list,PassionsActivity.this);
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
                    recyclerView.setAdapter(adapter);
                    Log.d("The Interest list api is success", "onResponse: "+response.body().getStatus());
                }
                else {
                    Log.d("The Interest list api is failed", "onResponse: "+response.message());
                }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<InterestListResponse>>> call, Throwable t) {
                Log.d("The Interest list api is success", "onResponse: "+t.getLocalizedMessage());
            }
        });

        adapter.setOnClickListener(new InterestAdapter.OnClickListener() {
            @Override
            public void onClick(int position, InterestListResponse model,View view) {
                view.setBackgroundColor(getResources().getColor(R.color.primaryColour));
            }
        });

        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(PassionsActivity.this, MainActivity.class);
                startActivity(in);
            }
        });


    }
}