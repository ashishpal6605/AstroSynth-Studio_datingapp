package com.example.bottom_bar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.R;
import com.example.bottom_bar.Response.InterestListResponse;
import com.example.bottom_bar.Response.SaveInterestResponse;

import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.ViewHolder> {
    List<InterestListResponse> list;
    Context context;
    int count =0;

    public InterestAdapter(List<InterestListResponse> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public InterestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.interest_recyclerview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull InterestAdapter.ViewHolder holder, int position) {
     holder.text.setText(list.get(position).getName());

     holder.itemView.setOnClickListener(v->{
         count++;
         if (count==1){
//             holder.itemView.setBackgroundResource();
             count--;
         }
         else {
             holder.itemView.setBackgroundResource(R.color.white);
         }

     });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
    TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.photopraphytxt);

        }
    }
}

