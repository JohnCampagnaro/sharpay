package com.sharpay.home;

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

public class HomeFragment extends BaseFragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_start).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switchToFragment(TutorialFragment.class.getName(), R.id.container, true);
    }
}
