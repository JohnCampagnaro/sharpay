package com.sharpay.order.activities;

import android.os.Bundle;

import com.sharpay.R;
import com.sharpay.common.BaseActivity;
import com.sharpay.order.fragments.QRCodeFragment;

public class StartTableActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        addFragment(QRCodeFragment.class.getName(), R.id.container, false);
    }
}
