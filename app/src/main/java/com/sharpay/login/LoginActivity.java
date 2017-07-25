package com.sharpay.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sharpay.R;
import com.sharpay.common.BaseActivity;
import com.sharpay.home.HomeActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.google_login).setOnClickListener(this);
        findViewById(R.id.facebook_login).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
