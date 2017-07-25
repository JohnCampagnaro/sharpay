package com.sharpay.common;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by johnc on 23/07/2017.
 */

public class BaseFragment extends Fragment {

    protected void switchToFragment(Fragment frag, int containerId, boolean addToBackStack) {
        switchToFragment(frag, containerId, addToBackStack, true);
    }

    protected void switchToFragment(Fragment frag, int containerId, boolean addToBackStack, boolean replace) {
        if (isActivityValid()) {
            final FragmentManager fm = getActivity().getSupportFragmentManager();
            Fragment fragment = fm.findFragmentById(containerId);

            FragmentTransaction ft = fm.beginTransaction();

            if (addToBackStack)
                ft.addToBackStack(frag.getClass().getName());

//            if (anim != FragmentTransitionAnimation.NONE)
//                ft.setCustomAnimations(anim.getEnterAnimId(), anim.getExitAnimId(), anim.getPopExitAnimId(), anim.getPopEnterAnimId());

            if (fragment == null || (addToBackStack && !replace)) {
                ft.add(containerId, frag);
                ft.commitAllowingStateLoss();
            } else {
                ft.replace(containerId, frag);
                ft.commitAllowingStateLoss();
            }
        }
    }

    protected void switchToFragment(String fragment, int containerId, boolean addToBackStack) {
        switchToFragment(fragment, containerId, new Bundle(), addToBackStack);
    }

    protected void switchToFragment(String fragment, int containerId, Bundle bundle, boolean addToBackStack) {
        switchToFragment(Fragment.instantiate(getActivity(), fragment, bundle), containerId, addToBackStack);
    }

    protected void switchToFragment(String fragment, int containerId, Bundle bundle, boolean addToBackStack, boolean replace) {
        switchToFragment(Fragment.instantiate(getActivity(), fragment, bundle), containerId, addToBackStack, replace);
    }

    public boolean isActivityValid() {
        return getActivity() != null && !getActivity().isFinishing();
    }
}
