package com.example.bottom_bar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bottom_bar.R;

import java.util.List;

public class MyPagerAdapter extends PagerAdapter {
    private final Context context;
    private final List<Integer> imageList;
    private final List<String> textList;

    public MyPagerAdapter(Context context, List<Integer> imageList, List<String> textList) {
        this.context = context;
        this.imageList = imageList;
        this.textList = textList;
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.view_pager_item, container, false);

        ImageView customImageView = view.findViewById(R.id.customImageView);
        TextView customTextView1 = view.findViewById(R.id.customTextView1);
        TextView customTextView2 = view.findViewById(R.id.customTextView2);

        customImageView.setImageResource(imageList.get(position));
        // Split the text based on the delimiter
        String[] textArray = textList.get(position).split("\\|");

        if (textArray.length >= 2) {
            customTextView1.setText(textArray[0]);
            customTextView2.setText(textArray[1]);
        } else if (textArray.length == 1) {
            customTextView1.setText(textArray[0]);
            customTextView2.setText("");
        }

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
