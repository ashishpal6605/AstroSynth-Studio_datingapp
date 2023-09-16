package com.example.bottom_bar.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Adapter.HomepageAdapter;
import com.example.bottom_bar.Model.HomepageModel;
import com.example.bottom_bar.R;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {


    RecyclerView recyclerView;

    HomepageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        recyclerView = findViewById(R.id.homerecycleview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        ArrayList<HomepageModel> itemList = generateItemList();
        adapter = new HomepageAdapter(itemList, this);
        recyclerView.setAdapter(adapter);
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