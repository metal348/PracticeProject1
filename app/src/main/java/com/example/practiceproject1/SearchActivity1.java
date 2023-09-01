package com.example.practiceproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class SearchActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search1);
        TextView tv = findViewById(R.id.textView);
        EditText ed = findViewById(R.id. editText);
        Button search = findViewById(R.id.SearchButton);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getName(tv, ed );
            }
        });
    }
    public void getName(TextView tv, EditText edit1){
        String name = String.valueOf(edit1.getText());
        getDetails(tv,name);
    }
    public void getDetails(TextView tv,String name){
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol="+name+".BSE&outputsize=full&apikey=G4I2WF3TPNJ8U5GT";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                String r = String.valueOf(response);
                try {
                    JSONObject metaData = response.getJSONObject("Meta Data");
                    String date = metaData.getString("3. Last Refreshed");
                    JSONObject timeSeries = response.getJSONObject("Time Series (Daily)");
                    JSONObject today = timeSeries.getJSONObject(date);
                    String data = "1. Open   ---->   "+ today.getString("1. open")+"\n";
                    data+= "2. High   ---->   "+ today.getString("2. high")+"\n";
                    data+= "3. Low   ---->   "+ today.getString("3. low")+"\n";
                    data+= "4. Close   ---->   "+ today.getString("4. close")+"\n";
                    data+= "5. Volume   ---->   "+ today.getString("5. volume")+"\n";
                    tv.setText(data);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tv.setText("Error");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }

}