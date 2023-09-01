package com.example.practiceproject1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practiceproject1.Data.DbHandler;
import com.example.practiceproject1.adapter.RvAdapter;
import com.example.practiceproject1.model.Trade;

import java.util.ArrayList;
import java.util.Collections;

public class Portfolio_Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RvAdapter rvAdapter;
    private ArrayList tradeArrayList;
    private ArrayAdapter arrayAdapter;
    DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        Intent intent1 = getIntent();
        recyclerView = findViewById(R.id.recyclerView);
//        DbHandler db = new DbHandler();
//        tradeArrayList =
        db = new DbHandler(Portfolio_Activity.this);
        tradeArrayList = new ArrayList();

        displayTrade();
        rvAdapter = new RvAdapter(Portfolio_Activity.this,Portfolio_Activity.this,tradeArrayList);
        Log.d("rv", String.valueOf(rvAdapter.getItemCount()));
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(Portfolio_Activity.this));

    }

    void displayTrade(){
        Cursor cursor = db.getAllTrades();


            while(cursor.moveToNext()){
                Trade trade = new Trade(cursor.getInt(0),cursor.getString(1),
                        cursor.getString(4),cursor.getString(5),
                        cursor.getInt(2),cursor.getInt(3));
                tradeArrayList.add(trade);
            }
            cursor.close();

        Log.d("count", "count "+tradeArrayList.size());
    }
}
