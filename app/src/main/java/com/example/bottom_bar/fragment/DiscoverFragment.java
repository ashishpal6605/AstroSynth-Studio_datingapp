package com.example.bottom_bar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Adapter.HomepageAdapter;
import com.example.bottom_bar.Model.HomepageModel;
import com.example.bottom_bar.R;
import com.example.bottom_bar.Response.BaseResponse;
import com.example.bottom_bar.Response.OtpVerify.PubListResponse;
import com.example.bottom_bar.network.RetrofitClient;
import com.example.bottom_bar.service.Api;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DiscoverFragment extends Fragment {


    RecyclerView recyclerView;

    HomepageAdapter adapter;
    ArrayList<HomepageModel> itemList;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        recyclerView = view.findViewById(R.id.homerecycleview);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        itemList = generateItemList();
        recyclerView.setLayoutManager(layoutManager);
        adapter=new HomepageAdapter(itemList,requireContext());
        recyclerView.setAdapter(adapter);


        Api service= RetrofitClient.getInstance().getApis();
        Call<BaseResponse<List<PubListResponse>>>  call= service.getPubList();

        call.enqueue(new Callback<BaseResponse<List<PubListResponse>>>() {
            @Override
            public void onResponse(Call<BaseResponse<List<PubListResponse>>> call, Response<BaseResponse<List<PubListResponse>>> response) {
                  if (response.isSuccessful()){
//                      for (int i=0;i<response.body().getData().size();i++){
//                          itemList.add(new HomepageModel(response.body().getData().get(i).getGallery(),response.body().getData().get(i).getName(),response.body().getData().get(i).getArea(),
//                                  response.body().getData().get(i).getRating(),response.body().getData().get(i).getShort_desc(),response.body().getData().get(i).getReview()
//                          ));
//                      }
//                      recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
//                      adapter = new HomepageAdapter(itemList, getContext());
//                      recyclerView.setAdapter(adapter);
                      Log.d("The pub list api is success", "onResponse: "+response.body().getStatus());
                  }
                  else {
                      Log.d("The pub list api is Failed", "onResponse: "+response.message());
                  }
            }

            @Override
            public void onFailure(Call<BaseResponse<List<PubListResponse>>> call, Throwable t) {
                Log.d("The pub list api is Failure", "onResponse: "+t.getLocalizedMessage());
            }
        });


        return view;
    }


    private ArrayList<HomepageModel> generateItemList() {
        ArrayList<HomepageModel> itemList = new ArrayList<>();
        itemList.add(new HomepageModel(R.drawable.bartender, "Cloud house", "5.9km", "3.3", "good", "(1110 reviews)"));
        itemList.add(new HomepageModel(R.drawable.bartender1, "Cloud house", "6.9km", "2.3", "average", "(1200 reviews)"));
        itemList.add(new HomepageModel(R.drawable.bartender, "Cloud house", "8.3km", "3.3", "good", "(180 reviews)"));
        itemList.add(new HomepageModel(R.drawable.bartender1, "Cloud house", "87.9km", "4.0", "good", "(1360 reviews)"));
        itemList.add(new HomepageModel(R.drawable.bartender, "Cloud house", "9.9km", "4.3", "good", "(120 reviews)"));
        itemList.add(new HomepageModel(R.drawable.bartender1, "Cloud house", "5.9km", "4.3", "good", "(120 reviews)"));

        return itemList;
    }
}