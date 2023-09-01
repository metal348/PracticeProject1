package com.example.practiceproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.practiceproject1.Data.DbHandler;
import com.example.practiceproject1.model.Trade;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddTrade_Activity extends AppCompatActivity {
    public final static String message = "return details";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_trade);


    }
    public void buy(View view){
        EditText sharename = findViewById(R.id.Sharename);
        EditText quantity = findViewById(R.id. quantity);
        EditText price = findViewById(R.id.price);
        String a = String.valueOf(sharename.getText());
        String b = String.valueOf(quantity.getText());
        String c = String.valueOf(price.getText());

        if(a=="" || b=="" || c==""){
            Toast.makeText(AddTrade_Activity.this,"Field is empty!",Toast.LENGTH_SHORT).show();
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        Trade trade = new Trade(0,a, formatter.format(date),"BUY",Integer.parseInt(c),Integer.parseInt(c));
        DbHandler db = new DbHandler(AddTrade_Activity.this);
        db.addTrade(trade);
        Toast.makeText(AddTrade_Activity.this,"Buy Order Recieved",Toast.LENGTH_SHORT).show();

    }
    public void sell(View view){
        Toast.makeText(AddTrade_Activity.this,"Sell Order Recieved",Toast.LENGTH_SHORT).show();

    }
}