package com.sharpay.order.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ListViewCompat;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ListView;

import com.sharpay.R;
import com.sharpay.common.BaseFragment;
import com.sharpay.order.OrderInfo;
import com.sharpay.order.OrdersAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnc on 23/07/2017.
 */

public class TableOrderFragment extends BaseFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private OrdersAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_table_order, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new OrdersAdapter(getContext(), getOrders());
        ListViewCompat orders = (ListViewCompat) view.findViewById(R.id.orders);
        orders.setAdapter(mAdapter);

        SwitchCompat myOrders = (SwitchCompat) view.findViewById(R.id.show_my_orders_switch);
        myOrders.setOnCheckedChangeListener(this);

        view.findViewById(R.id.button_pay).setOnClickListener(this);
    }

    //TODO criar lista tempoária de pedidos
    private List<OrderInfo> getOrders() {
        List<OrderInfo> orders = new ArrayList<>();
        orders.add(new OrderInfo("Cerveja Brahma 600ml", 8.f, "MS", 1500951160));
        orders.add(new OrderInfo("Caipirinha de Limão", 12.f, "AD", 1500951260));
        orders.add(new OrderInfo("Hamburguer", 19.50f, "MS", 1500951140));
        orders.add(new OrderInfo("Fritas", 18.f, "JC", 1500951180));
        orders.add(new OrderInfo("Coca cola", 3.5f, "JC", 1500951360));
        orders.add(new OrderInfo("Cerveja Brahma 600ml", 8.f, "VH", 1500951320));

        return orders;
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            mAdapter.filter("JC");
        } else
            mAdapter.filter(null);
    }

    @Override
    public void onClick(View v) {
        switchToFragment(PayOrderFragment.class.getName(), R.id.container, true);
    }
}
