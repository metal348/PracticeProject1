package com.example.practiceproject1.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practiceproject1.R;
import com.example.practiceproject1.model.Trade;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyViewHolder> {
    Context context;
    ArrayList tradeList;
    Activity activity;

    public RvAdapter(Activity activity,Context context, ArrayList tradeList) {
        this.activity = activity;
        this.context = context;
        this.tradeList = tradeList;
    }

    @NonNull
    @Override
    public RvAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        View view = layoutInflater.inflate(R.layout.row,parent,false);
        if(view == null)
            Log.d("null view", "null view");
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RvAdapter.MyViewHolder holder, final int position) {

        Trade trade = (Trade) tradeList.get(position);
        if(trade == null)
            Log.d("null","null");
        else
            Log.d("null",trade.getShare_name());
        holder.sharename.setText(trade.getShare_name());
        holder.shareprice.setText(String.valueOf(trade.getShare_price()));
        holder.sharequantity.setText(String.valueOf(trade.getShare_quantity()));
        String am = String.valueOf(trade.getShare_price()*trade.getShare_quantity());
        holder.amount.setText(am);
        holder.order.setText(trade.getTrade_type());
    }

    @Override
    public int getItemCount() {
        return tradeList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sharename,shareprice,sharequantity,amount,order;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            sharename = itemView.findViewById(R.id. sharename);
            shareprice = itemView.findViewById(R.id. shareprice);
            sharequantity = itemView.findViewById(R.id. sharequantity);
            amount = itemView.findViewById(R.id . amount);
            order = itemView.findViewById(R.id . order);

        }
    }
}
