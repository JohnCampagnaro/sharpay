package com.sharpay.order;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sharpay.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

/**
 * Created by johnc on 24/07/2017.
 */

public class OrdersAdapter extends BaseAdapter {
    private Context mContext;
    private List<OrderInfo> mOrders;
    private List<OrderInfo> mOrdersFiltered;

    public OrdersAdapter(Context context, List<OrderInfo> orders) {
        mContext = context;
        mOrders = orders;
        mOrdersFiltered = new ArrayList<>(orders);
    }

    public void filter(String owner) {
        if (owner == null) {
            mOrdersFiltered = new ArrayList<>(mOrders);
        } else {
            mOrdersFiltered = new ArrayList<>();
            for (OrderInfo order : mOrders) {
                if (owner.equals(order.getOwner())) {
                    mOrdersFiltered.add(order);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mOrdersFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return mOrdersFiltered.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        Holder holder;
        if (convertView == null) {
            view = inflater.inflate(R.layout.order_item, null);
            holder = new Holder(view);
            view.setTag(holder);
        } else {
            view = convertView;
            holder = (Holder) view.getTag();
        }

        setViewData(holder, mOrdersFiltered.get(position));

        return view;
    }

    private void setViewData(Holder holder, OrderInfo order) {
        holder.mOwner.setText(order.getOwner());
        holder.mItem.setText(order.getItem());
        holder.mTime.setText(((System.currentTimeMillis()/1000) - order.getTime()) + "s");
        NumberFormat format = NumberFormat.getCurrencyInstance();
        holder.mPrice.setText(format.format(order.getPrice()));
    }

    private class Holder {
        private TextView mOwner;
        private TextView mPrice;
        private TextView mItem;
        private TextView mTime;

        Holder(View view) {
            mOwner = (TextView) view.findViewById(R.id.owner);
            mPrice = (TextView) view.findViewById(R.id.price);
            mItem = (TextView) view.findViewById(R.id.item_name);
            mTime = (TextView) view.findViewById(R.id.order_time);
        }
    }
}
