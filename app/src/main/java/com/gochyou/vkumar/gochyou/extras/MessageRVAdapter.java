package com.gochyou.vkumar.gochyou.extras;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gochyou.vkumar.gochyou.R;
import com.gochyou.vkumar.gochyou.entities.Message;


import java.util.List;

public class MessageRVAdapter extends RecyclerView.Adapter<MessageRVAdapter.MyViewHolder> {

    private List<Message> messages;

    public MessageRVAdapter(List<Message> messages) {
        this.messages = messages;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView message;
        public TextView timestamp;
        public MyViewHolder(View view) {
            super(view);
            message = (TextView) view.findViewById(R.id.rvMessage);
            timestamp =  (TextView) view.findViewById(R.id.timestamp);

        }
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Message msg = messages.get(position);
        holder.message.setText(msg.getMessage());
        holder.timestamp.setText((CharSequence) msg.getCreatedAt());
        System.out.println(msg.getCreatedAt());

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rvmessages_row, parent, false);
        return new MyViewHolder(itemView);
    }



    @Override
    public int getItemCount() {
        return messages.size();
    }
}
