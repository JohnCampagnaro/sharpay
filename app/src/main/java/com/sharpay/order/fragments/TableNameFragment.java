package com.sharpay.order.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.sharpay.R;
import com.sharpay.common.BaseFragment;
import com.sharpay.order.activities.OrderActivity;

/**
 * Created by johnc on 23/07/2017.
 */

public class TableNameFragment extends BaseFragment implements View.OnClickListener, View.OnFocusChangeListener {

    private View mTableNameLabel;
    private View mButtonStart;
    private EditText mTableName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_table_name, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTableNameLabel = view.findViewById(R.id.table_name_label);

        mTableName = (EditText) view.findViewById(R.id.table_name);
        mTableName.setOnFocusChangeListener(this);
        mTableName.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (v.getId() == R.id.table_name) {
                    if (keyCode == KeyEvent.KEYCODE_ENTER) {
                        if (mTableName.length() > 0)
                            goToOrder();

                        return true;
                    }

                    mButtonStart.setEnabled(mTableName.length() > 0);
                }

                return false;
            }
        });

        mTableName.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                goToOrder();
                return false;
            }
        });
        mTableName.setImeActionLabel("Custom text", KeyEvent.KEYCODE_ENTER);

        mButtonStart = view.findViewById(R.id.button_start);
        mButtonStart.setOnClickListener(this);
        mButtonStart.setEnabled(false);
    }

    @Override
    public void onClick(View v) {
        goToOrder();
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        mTableNameLabel.setVisibility((hasFocus ? View.VISIBLE : View.INVISIBLE));
    }

    private void goToOrder() {
        startActivity(new Intent(getActivity(), OrderActivity.class));

        getActivity().finish();
    }
}
