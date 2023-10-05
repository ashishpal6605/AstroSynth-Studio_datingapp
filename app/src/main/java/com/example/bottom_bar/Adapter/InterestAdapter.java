package com.example.bottom_bar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottom_bar.R;
import com.example.bottom_bar.Response.InterestListResponse;
import com.example.bottom_bar.Response.SaveInterestResponse;
import com.example.bottom_bar.utils.DoubleClickListener;

import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.ViewHolder> {
    List<InterestListResponse> list;
    Context context;
    private OnClickListener onClickListener;
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

     holder.text.setOnClickListener(n->{
       if (count==0){
           count++;
           holder.text.setBackgroundResource(R.drawable.interest);
       }else {
           count--;
           holder.text.setBackgroundResource(R.drawable.whit);
       }
     });
    }
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public interface OnClickListener {
        void onClick(int position, InterestListResponse model,View view);
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

