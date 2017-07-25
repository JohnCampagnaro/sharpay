package com.sharpay.order;

/**
 * Created by johnc on 24/07/2017.
 */

public class OrderInfo {
    private String mItem;
    private float mPrice;
    private String mOwner;
    private long mTime;

    public OrderInfo(String item, float price, String owner, long time){
        mItem = item;
        mPrice = price;
        mOwner = owner;
        mTime = time;
    }

    public String getItem() {
        return mItem;
    }

    public float getPrice() {
        return mPrice;
    }

    public String getOwner() {
        return mOwner;
    }

    public long getTime() {
        return mTime;
    }
}
