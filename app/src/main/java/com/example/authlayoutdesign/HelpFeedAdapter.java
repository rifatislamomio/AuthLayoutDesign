package com.example.authlayoutdesign;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelpFeedAdapter extends RecyclerView.Adapter<HelpFeedAdapter.MyViewHolder>
{

    Context context;
    ArrayList<Post> postList;

    public HelpFeedAdapter(Context c, ArrayList<Post> postList)
    {
        context = c;
        this.postList = postList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.post_view,parent,false));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.userName.setText(postList.get(position).getUserName());
        //Date and Time
        String dateNtime = "";
        holder.dateTime.setText(dateNtime);
        holder.postBody.setText(postList.get(position).getPostBody());


        String phone_number = postList.get(position).getContactNO();
        holder.contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    //user phone_number to call
            }
        });




        holder.comment.setText(postList.get(position).getCommentCount()+"");


    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView userName,dateTime,postBody,comment,contact;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.textView_username);
            dateTime = itemView.findViewById(R.id.textView_DatenTime);
            postBody = itemView.findViewById(R.id.description_Text);
            comment = itemView.findViewById(R.id.Comment_Counter_PostView);
            contact = itemView.findViewById(R.id.Contact_PostView);
        }
    }
}
