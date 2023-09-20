package com.example.bottom_bar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.bottom_bar.Activity.SignupActivity;
import com.example.bottom_bar.R;
import com.google.firebase.auth.FirebaseAuth;


public class MoreFragment extends Fragment {



    public MoreFragment() {
        // Required empty public constructor
    }
    ImageButton logoutBtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_more, container, false);
        logoutBtn=view.findViewById(R.id.profile_logoutbtn);

                logoutBtn.setOnClickListener( v->{
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(requireContext(), SignupActivity.class));
                    getActivity().finish();
        });
        return view;
    }
}