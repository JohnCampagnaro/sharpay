package com.sharpay.order.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharpay.R;
import com.sharpay.common.BaseFragment;

/**
 * Created by johnc on 27/07/2017.
 */

public class PayOrderFragment extends BaseFragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_pay_order, container, false);

        return view;
    }
}
