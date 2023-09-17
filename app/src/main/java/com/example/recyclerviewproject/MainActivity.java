package com.example.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    // 1 Adapter view
    RecyclerView recyclerView;

    // 2 data source
    VaccineModel[] myListData;

    // 3  adapter

    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView =findViewById(R.id.recyclerView);

        myListData = new VaccineModel[]{
                new VaccineModel("Brazil", R.drawable.brazil),
                new VaccineModel("Argentina", R.drawable.argentina),
                new VaccineModel("Germany", R.drawable.germany),
                new VaccineModel("France", R.drawable.france),
                new VaccineModel("Uruguay", R.drawable.uruguay),
                new VaccineModel("Croatia", R.drawable.croatia),
                new VaccineModel("Portugal", R.drawable.portugal),
                new VaccineModel("USA", R.drawable.usa),
                new VaccineModel("Japan", R.drawable.japan),
                new VaccineModel("England", R.drawable.england),
                new VaccineModel("Belgium", R.drawable.belgium),
        };

        // Adapter

        adapter = new MyAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        recyclerView.setAdapter(adapter);

        // Handling the click events
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Team: "+ myListData[pos].getTitle(),
                Toast.LENGTH_SHORT).show();
    }
}