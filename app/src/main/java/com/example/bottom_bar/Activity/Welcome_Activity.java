package com.example.bottom_bar.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bottom_bar.Adapter.MyPagerAdapter;
import com.example.bottom_bar.R;
import com.example.bottom_bar.utils.SessionManager;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Welcome_Activity extends AppCompatActivity {
    private final Handler handler = new Handler();
    private final int delay = 2000; // Delay in milliseconds (adjust as needed)
    Button createaccount;

    SessionManager manager;


    TextView tvSignin;
    private ViewPager viewPager;
    private LinearLayout indicatorLayoutContainer;
    private List<ImageView> indicatorDots;
    private int currentPage = 0;
    private final Runnable runnable = new Runnable() {
        public void run() {
            if (viewPager != null) {
                if (currentPage == viewPager.getAdapter().getCount() - 1) {
                    currentPage = 0;
                } else {
                    currentPage++;
                }
                viewPager.setCurrentItem(currentPage);
            }
            handler.postDelayed(this, delay);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        createaccount = findViewById(R.id.btn_Create_Account);
        viewPager = findViewById(R.id.pagerIntroSlider);
        indicatorLayoutContainer = findViewById(R.id.indicatorLayoutContainer);
        tvSignin = findViewById(R.id.tvSignin);
        manager=new SessionManager(this);

   if (!manager.getToken().isEmpty()){
       startActivity(new Intent(Welcome_Activity.this,MainActivity.class));
   }
        List<Integer> imageList = Arrays.asList(R.drawable.girl1, R.drawable.girl2, R.drawable.girl3);
        List<String> textList = Arrays.asList(
                "Premium|Sign up today and enjoy the first month\n" +
                        "of premium benefits on us.",
                "Matches|We match you with people that have a\n" +
                        "large array of similar interests.",
                "Algorithm|Users going through a vetting process to ensure you never match with bots."
        );

        MyPagerAdapter adapter = new MyPagerAdapter(this, imageList, textList);
        viewPager.setAdapter(adapter);

        indicatorDots = new ArrayList<>();

        // Create and add indicator dots to the indicator layout
        for (int i = 0; i < imageList.size(); i++) {
            ImageView dot = new ImageView(this);
            dot.setImageResource(R.drawable.indicator_dot_unselected);
            indicatorDots.add(dot);
            indicatorLayoutContainer.addView(dot);
        }

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                updateIndicatorDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        // Start auto-swiping
        handler.postDelayed(runnable, delay);


        createaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome_Activity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
        tvSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome_Activity.this, LoginEmailActivity.class);
                startActivity(intent);
            }
        });

    }

    private void updateIndicatorDots(int position) {
        for (int i = 0; i < indicatorDots.size(); i++) {
            if (i == position) {
                indicatorDots.get(i).setImageResource(R.drawable.indicator_dot_selected);
            } else {
                indicatorDots.get(i).setImageResource(R.drawable.indicator_dot_unselected);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}





