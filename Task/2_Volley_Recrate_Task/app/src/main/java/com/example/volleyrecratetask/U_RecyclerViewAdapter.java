package com.example.volleyrecratetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import java.util.List;

public class U_RecyclerViewAdapter extends RecyclerView.Adapter<U_RecyclerViewAdapter.MyViewHolder> {
    Context context;
    List<UserModel> userModels;

    public U_RecyclerViewAdapter(Context context, List<UserModel> userModels) {
        this.context = context;
        this.userModels = userModels;
    }

    @NonNull
    @Override
    public U_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

//        This is where you inflate the layout(Giving a look to our Row)
        return new U_RecyclerViewAdapter.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull U_RecyclerViewAdapter.MyViewHolder holder, int position) {
//        assigning values to the views we crated in recycler_view_row layout file
//        based on the position of recycler view
//        setting image
        holder.textViewName.setText(userModels.get(position).getFrist_name() + " " + userModels.get(position).getLast_name());
//        holder.imageView.setImageResource(userModels.get(position).getAvatar());
        Picasso.get().load(userModels.get(position).getAvatar()).into(holder.imageView);
        holder.emailText.setText(userModels.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        //        the recycler view just wants to know the number of items you want displayed
        return userModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        //        Grabbing the view from our recycler view row layout file
//        kind like in the Oncreate method()
        ImageView imageView;
        TextView textViewName;
        TextView emailText;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textView);
            emailText = itemView.findViewById(R.id.emailView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), textViewName.getText(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
