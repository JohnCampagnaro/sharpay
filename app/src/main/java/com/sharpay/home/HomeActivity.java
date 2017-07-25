package com.sharpay.home;

import android.os.Bundle;

import com.sharpay.R;
import com.sharpay.common.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        addFragment(HomeFragment.class.getName(), R.id.container, false);
    }
}
