package com.example.bottom_bar.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Activity.HomeDetailPage;
import com.example.bottom_bar.Model.HomepageModel;
import com.example.bottom_bar.R;
import com.google.android.material.card.MaterialCardView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomepageAdapter extends RecyclerView.Adapter<HomepageAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<HomepageModel> localDataSet;

    public HomepageAdapter(ArrayList<HomepageModel> itemList, Context context) {
        this.context = context;
        this.localDataSet = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lyt_homepage, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomepageModel homepageModel = localDataSet.get(position);

        holder.barname.setText(homepageModel.getBarname());
        holder.distance.setText(homepageModel.getBardistance());
        holder.review.setText(homepageModel.getBarreview());
        holder.condition.setText(homepageModel.getBarcondition());
        // Load the image using Picasso
        Picasso.get()
                .load(homepageModel.getImage()) // Assuming 'image' is an int resource ID
                .into(holder.barimage);


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, HomeDetailPage.class);
//                intent.putExtra("item_position", position);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView barname;
        public TextView distance;
        public TextView review;
        public TextView condition;
        public ImageView barimage;
        MaterialCardView cv;


        public ViewHolder(View view) {
            super(view);
            barname = view.findViewById(R.id.barname);
            distance = view.findViewById(R.id.barDistance);
            review = view.findViewById(R.id.barreview);
            barimage = view.findViewById(R.id.barimage);
            condition = view.findViewById(R.id.barcondition);
            cv = view.findViewById(R.id.cardview_homepage);
        }
    }
}
