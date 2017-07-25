package com.sharpay.order.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sharpay.R;
import com.sharpay.common.BaseFragment;

/**
 * Created by johnc on 23/07/2017.
 */

public class EmptyTableFragment extends BaseFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_empty_table, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.placeholder).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switchToFragment(TableOrderFragment.class.getName(), R.id.container, true);
    }
}
