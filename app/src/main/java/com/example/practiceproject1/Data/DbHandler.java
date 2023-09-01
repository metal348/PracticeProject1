package com.example.practiceproject1.Data;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.practiceproject1.Parameters.Params;
import com.example.practiceproject1.model.Trade;

import java.util.ArrayList;
import java.util.List;

public class DbHandler extends SQLiteOpenHelper {
    public DbHandler(@Nullable Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = " create table "+Params.TABLE_NAME+" ( "+Params.KEY_ID+" integer primary key, "
                + Params.KEY_SHARE_NAME+" text, "+ Params.KEY_SHARE_PRICE+ " int ,"+Params.KEY_SHARE_QUANTITY+ " int, "
                +Params.KEY_TRADE_DATE+ " text , "+ Params.KEY_TRADE_TYPE+" text)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void addTrade(Trade trade){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_SHARE_NAME,trade.getShare_name());
        values.put(Params.KEY_SHARE_PRICE,trade.getShare_price());
        values.put(Params.KEY_SHARE_QUANTITY,trade.getShare_quantity());
        values.put(Params.KEY_TRADE_DATE,trade.getTrade_date());
        values.put(Params.KEY_TRADE_TYPE,trade.getTrade_type());

        db.insert(Params.TABLE_NAME,null,values);
        db.close();
    }

    @SuppressLint("SuspiciousIndentation")
    public Cursor getAllTrades(){

        String sql = "select * from "+ Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor == null)
            Log.d("cur", "getAllTrades: null");
            return cursor;
    }
}
