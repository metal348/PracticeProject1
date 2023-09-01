package com.example.practiceproject1.model;

public class Trade {
    private int id;
    private String share_name,trade_date,trade_type;
    private int share_price,share_quantity;

    public Trade(int id, String share_name, String trade_date, String trade_type, int share_price, int share_quantity) {
        this.id = id;
        this.share_name = share_name;
        this.trade_date = trade_date;
        this.trade_type = trade_type;
        this.share_price = share_price;
        this.share_quantity = share_quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShare_name() {
        return share_name;
    }

    public void setShare_name(String share_name) {
        this.share_name = share_name;
    }

    public String getTrade_date() {
        return trade_date;
    }

    public void setTrade_date(String trade_date) {
        this.trade_date = trade_date;
    }

    public String getTrade_type() {
        return trade_type;
    }

    public void setTrade_type(String trade_type) {
        this.trade_type = trade_type;
    }

    public int getShare_price() {
        return share_price;
    }

    public void setShare_price(int share_price) {
        this.share_price = share_price;
    }

    public int getShare_quantity() {
        return share_quantity;
    }

    public void setShare_quantity(int share_quantity) {
        this.share_quantity = share_quantity;
    }
}
