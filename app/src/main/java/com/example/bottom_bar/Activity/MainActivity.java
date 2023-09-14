package com.example.bottom_bar.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bottom_bar.R;
import com.example.bottom_bar.fragment.DiscoverFragment;
import com.example.bottom_bar.fragment.MatchedFragment;
import com.example.bottom_bar.fragment.MessegeFragment;
import com.example.bottom_bar.fragment.MoreFragment;

import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class MainActivity extends AppCompatActivity {

    SmoothBottomBar bottomnavBar;
    Toolbar tolBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomnavBar = findViewById(R.id.bottom_Nav_Bar);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, new DiscoverFragment());
        fragmentTransaction.commit();

        bottomnavBar.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

                if (i == 0) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new DiscoverFragment());
                    fragmentTransaction.commit();
                }
                if (i == 1) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new MatchedFragment());
                    fragmentTransaction.commit();
                }
                if (i == 2) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new MessegeFragment());
                    fragmentTransaction.commit();
                }
                if (i == 3) {

                    FragmentManager fragmentManager = getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayout, new MoreFragment());
                    fragmentTransaction.commit();
                }
                return false;
            }
        });
    }
}