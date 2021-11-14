package com.example.recyclerview_yt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class A_RecylerViewAdapter extends RecyclerView.Adapter<A_RecylerViewAdapter.MyViewHolder> {

    Context context;
    ArrayList<AnimalModel> animalModels;

    A_RecylerViewAdapter(Context context, ArrayList<AnimalModel> animalModels) {
        this.context = context;
        this.animalModels = animalModels;
    }


    @NonNull
    @Override
    public A_RecylerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_view_row,parent,false);

//        This is where you inflate the layout(Giving a look to our Row)
        return new A_RecylerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull A_RecylerViewAdapter.MyViewHolder holder, int position) {
//        assigning values to the views we crated in recycler_view_row layout file
//        based on the position of recycler view
//        setting image

        holder.textViewName.setText(animalModels.get(position).getAnimalName());
        holder.imageView.setImageResource(animalModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
//        the recycler view just wants to know the number of items you want displayed
        return animalModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
//        Grabbing the view from our recycler view row layout file
//        kind like in the Oncreate method()

        ImageView imageView;
        TextView textViewName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textViewName = itemView.findViewById(R.id.textView);
        }
    }
}
