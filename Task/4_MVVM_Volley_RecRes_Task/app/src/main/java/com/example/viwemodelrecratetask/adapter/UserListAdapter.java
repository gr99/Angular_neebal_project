package com.example.viwemodelrecratetask.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.viwemodelrecratetask.R;
import com.example.viwemodelrecratetask.model.User;
import com.example.viwemodelrecratetask.viewmodel.UserListViewModel;

import java.util.Collections;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.MyViewHolder> {

    private Context context;
    private List<User> userList;
    private ItemClickListener clickListener;


    public UserListAdapter(Context context, List<User> userList,ItemClickListener clickListener) {
        this.context = context;
        this.userList = userList;
        this.clickListener = clickListener;
    }

    public void setUserListAdapter(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.tvTitle.setText(this.userList.get(position).getFrist_name() + " " + this.userList.get(position)
                .getLast_name());
        Glide.with(context)
                .load(this.userList.get(position).getAvatar())
                .circleCrop()
                .into(holder.imageView);
        holder.emailView.setText((this.userList.get(position).getEmail()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                clickListener.onUserClick(userList.get(position));
            }
        });


    }


    @Override
    public int getItemCount() {
        if (this.userList != null) {
            return this.userList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView emailView;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.textView);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            emailView = (TextView) itemView.findViewById(R.id.emailView);
        }
    }


    public interface ItemClickListener{
        public void onUserClick(User user);
    }
}
