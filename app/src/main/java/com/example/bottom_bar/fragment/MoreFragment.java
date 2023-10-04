package com.example.bottom_bar.fragment;


import android.content.Intent;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bottom_bar.Activity.SignupActivity;
import com.example.bottom_bar.R;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.makeramen.roundedimageview.RoundedImageView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MoreFragment extends Fragment {

    RoundedImageView profileimg;
    ImageView pickimagebtn;
    Activity activity;

    public MoreFragment() {
        // Required empty public constructor
    }

    ImageButton logoutBtn;

    @Override
    public void onAttach(@NonNull Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        profileimg = view.findViewById(R.id.user_profile);
        pickimagebtn = view.findViewById(R.id.profilecamerabutton);
        pickimagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImagePicker.Companion.with(MoreFragment.this)
                        .crop()
                        .start();
            }
        });
      logoutBtn=view.findViewById(R.id.profile_logoutbtn);

                logoutBtn.setOnClickListener( v->{
                    startActivity(new Intent(requireContext(), SignupActivity.class));
                    getActivity().finish();
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ImagePicker.REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            Uri uri = data.getData();
            profileimg.setImageURI(uri);
        }
    }
}
