package com.example.practiceproject1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.practiceproject1.Data.DbHandler;
import com.google.android.material.bottomappbar.BottomAppBar;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    public void searchPage(View view){
        TextView tv = findViewById(R.id.textView2);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageButton search = findViewById(R.id.imButton);

                Intent intent = new Intent(this, SearchActivity1.class);
                startActivity(intent);
    }
    public void addTrade(View view){
        ImageButton add = findViewById(R.id.imButton2);
        Intent intent = new Intent(this,AddTrade_Activity.class);
        startActivity(intent);
    }
    public void portfolio(View view){
        ImageButton add = findViewById(R.id.imButton5);
        Intent intent1 = new Intent(this,Portfolio_Activity.class);
        startActivity(intent1);
    }



}