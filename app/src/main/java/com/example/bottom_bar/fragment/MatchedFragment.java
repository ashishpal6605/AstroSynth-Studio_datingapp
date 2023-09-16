package com.example.bottom_bar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Activity.UserProfile;
import com.example.bottom_bar.Adapter.MatchedFragmentAdapter;
import com.example.bottom_bar.Model.MatchedModel;
import com.example.bottom_bar.R;

import java.util.ArrayList;
import java.util.List;


public class MatchedFragment extends Fragment {


    LinearLayout btn;


    public MatchedFragment() {
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
        View view = inflater.inflate(R.layout.fragment_matched, container, false);
        btn = view.findViewById(R.id.settingbtn);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2)); // Adjust the spanCount as needed for your grid


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inside your fragment's code
                Intent intent = new Intent(getActivity(), UserProfile.class);
                startActivity(intent);


            }
        });


        // Create some dummy data
        List<MatchedModel> dummyDataList = new ArrayList<>();
        dummyDataList.add(new MatchedModel(R.drawable.girl1, "Leilani, 19"));
        dummyDataList.add(new MatchedModel(R.drawable.girl1, "Leilani, 19"));
        dummyDataList.add(new MatchedModel(R.drawable.girl1, "Leilani, 19"));
        dummyDataList.add(new MatchedModel(R.drawable.girl2, "Annabelle, 20"));
        dummyDataList.add(new MatchedModel(R.drawable.girl2, "Annabelle, 20"));
        dummyDataList.add(new MatchedModel(R.drawable.girl2, "Annabelle, 20"));
        dummyDataList.add(new MatchedModel(R.drawable.girl3, "Reagan, 24"));
        dummyDataList.add(new MatchedModel(R.drawable.girl3, "Reagan, 24"));
        dummyDataList.add(new MatchedModel(R.drawable.girl3, "Reagan, 24"));


        // Set the dummy data in the adapter
        MatchedFragmentAdapter adapter = new MatchedFragmentAdapter(dummyDataList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}