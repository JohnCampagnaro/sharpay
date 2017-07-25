package com.sharpay.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by johnc on 22/07/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected void addFragment(Fragment frag, int container, boolean addToBackStack) {
        final FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(container);

        FragmentTransaction ft = fm.beginTransaction();

        if (addToBackStack)
            ft.addToBackStack(frag.getClass().getName());

//        if (anim != FragmentTransitionAnimation.NONE)
//            ft.setCustomAnimations(anim.getEnterAnimId(), anim.getExitAnimId(), anim.getPopExitAnimId(), anim.getPopEnterAnimId());

        if (isFinishing())
            return;

        if (fragment == null || addToBackStack) {
            ft.add(container, frag, frag.getClass().getName());
            ft.commitAllowingStateLoss();
        } else {
            ft.replace(container, frag, frag.getClass().getName());
            ft.commitAllowingStateLoss();
        }
    }

    protected void addFragment(String fragment, int container, boolean addToBackStack) {
        addFragment(fragment, container, new Bundle(), addToBackStack);
    }

    protected void addFragment(String fragment, int container, Bundle bundle, boolean addToBackStack) {
        addFragment(Fragment.instantiate(this, fragment, bundle), container, addToBackStack);
    }

    protected Fragment getCurrentFragment(int containerId) {
        final FragmentManager fm = getSupportFragmentManager();
        return fm.findFragmentById(containerId);
    }
}
