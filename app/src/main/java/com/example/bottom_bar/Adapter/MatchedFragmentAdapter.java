package com.example.bottom_bar.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.Model.MatchedModel;
import com.example.bottom_bar.R;

import java.util.List;

public class MatchedFragmentAdapter extends RecyclerView.Adapter<MatchedFragmentAdapter.ViewHolder> {
    private final List<MatchedModel> dataList;

    public MatchedFragmentAdapter(List<MatchedModel> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchedModel data = dataList.get(position);

        // Bind your data to the views here, e.g., holder.imageView.setImageResource(data.getImageResource());
// Bind your data to the views here.
        holder.imageView.setImageResource(data.getImageResource());
        holder.titleTextView.setText(data.getTitle()); // Set the title


        // Set click listeners for your ImageButtons if needed.
        holder.imageButton1.setOnClickListener(v -> {
            // Handle button 1 click here
        });
        holder.imageButton2.setOnClickListener(v -> {
            // Handle button 2 click here
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        ImageButton imageButton1;
        ImageButton imageButton2;
        TextView titleTextView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            imageButton1 = itemView.findViewById(R.id.imageButton1);
            imageButton2 = itemView.findViewById(R.id.imageButton2);
            titleTextView = itemView.findViewById(R.id.title);

        }
    }
}
