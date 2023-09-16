package com.example.bottom_bar.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Adapter.MessageAdapter;
import com.example.bottom_bar.Model.MessageModel;
import com.example.bottom_bar.R;

import java.util.ArrayList;
import java.util.List;

public class MessegeFragment extends Fragment {


    Activity activity;
    RecyclerView recyclerView;

    MessageAdapter adapter;

    public MessegeFragment() {
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
        View view = inflater.inflate(R.layout.fragment_messege, container, false);

        activity = getActivity();
        recyclerView = view.findViewById(R.id.msgrecycleview);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);


        List<MessageModel> itemList = generateItemList();
        adapter = new MessageAdapter(itemList);
        recyclerView.setAdapter(adapter);


        return view;
    }

    private List<MessageModel> generateItemList() {
        List<MessageModel> itemList = new ArrayList<>();
        itemList.add(new MessageModel(R.drawable.girl1, "01:30 am", "Arina", "hyy"));
        itemList.add(new MessageModel(R.drawable.girl1, "01:30 am", "Arina", "hyy"));
        itemList.add(new MessageModel(R.drawable.girl2, "02:45 pm", "John", "Hello!"));
        itemList.add(new MessageModel(R.drawable.girl3, "03:15 am", "Emma", "Hi there!"));
        itemList.add(new MessageModel(R.drawable.girl2, "04:00 pm", "Michael", "Hey, how are you?"));
        itemList.add(new MessageModel(R.drawable.girl2, "04:00 pm", "Michael", "Hey, how are you?"));
        itemList.add(new MessageModel(R.drawable.girl2, "04:00 pm", "Michael", "Hey, how are you?"));
        itemList.add(new MessageModel(R.drawable.girl2, "04:00 pm", "Michael", "Hey, how are you?"));
        itemList.add(new MessageModel(R.drawable.girl2, "04:00 pm", "Michael", "Hey, how are you?"));

        return itemList;
    }


}