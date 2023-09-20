package com.example.bottom_bar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bottom_bar.Model.MessageModel;
import com.example.bottom_bar.R;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    Context context;

    private ArrayList<MessageModel> localDataSet;

    public MessageAdapter(List<MessageModel> itemList) {
        super();
        this.localDataSet = (ArrayList<MessageModel>) itemList;
    }


    public MessageAdapter(ArrayList<MessageModel> dataSet, Context context) {
        this.context = context;
        this.localDataSet = dataSet;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilteredList(ArrayList<MessageModel> filteredList) {
        this.localDataSet = filteredList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.lytchat, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        MessageModel messageModel = localDataSet.get(position);
        ViewHolder.name.setText(messageModel.getName());
        ViewHolder.time.setText(messageModel.getTime());
        ViewHolder.lastmessege.setText(messageModel.getLastMessage());

//        Log.d("Glide", "Context: " + context);
//        Glide.with(context)
//                .load(messageModel.getImage()) // Get the image URL from the model
//                .placeholder(R.drawable.girl1) // Placeholder image while loading
//                .error(R.drawable.girl1) // Error image if loading fails
//                .into(viewHolder.profileimg);


//        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.chat_container, new ChatSinglePersonFragment()).addToBackStack(null).commit();
//            }
//        });


    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    protected void onDestroy() {
        super.notify();
        Glide.with(context).onDestroy();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public static TextView name;
        public static TextView lastmessege;
        public static TextView time;
        public static ImageView profileimg;
        MaterialCardView cv;
        LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.chat_username);
            lastmessege = view.findViewById(R.id.chat_lastmsg);
            time = view.findViewById(R.id.msgtime);
            profileimg = view.findViewById(R.id.chat_profileimg);
            linearLayout = view.findViewById(R.id.chatpersonrow);
            cv = view.findViewById(R.id.chat_personslist_cv);


        }

    }

}
