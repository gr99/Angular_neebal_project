package com.example.recyclerview_yt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<AnimalModel> animalModels = new ArrayList<>();

    int[] animalsImages = {R.drawable.ic_aardvark,
            R.drawable.ic_adelie_penguin,
            R.drawable.ic_african_bullfrog,
            R.drawable.ic_african_bullfrog,
            R.drawable.ic_african_clawed_frog,
            R.drawable.ic_adelie_penguin,
            R.drawable.ic_african_penguin,R.drawable.ic_alaskan_klee_kai,
            R.drawable.ic_aidi,R.drawable.ic_dog};

    private void setAnimalModels() {
        String[] animalNames = getResources().getStringArray(R.array.animals);
        for (int i = 0; i < animalNames.length; i++) {
            animalModels.add(new AnimalModel(animalNames[i],animalsImages[i]));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView=findViewById(R.id.mRecyclerView);
        setAnimalModels();
        A_RecylerViewAdapter adapter=new A_RecylerViewAdapter(this,animalModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}