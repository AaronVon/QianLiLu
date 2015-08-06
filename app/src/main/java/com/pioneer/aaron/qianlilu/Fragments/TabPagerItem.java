package com.pioneer.aaron.qianlilu.Fragments;

import android.support.v4.app.Fragment;

/**
 * Created by Aaron on 8/6/15.
 */
public class TabPagerItem {
    private final CharSequence titleSequence;
    private final Fragment fragment;

    public TabPagerItem(CharSequence titleSequence, Fragment fragment) {
        this.fragment = fragment;
        this.titleSequence = titleSequence;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public CharSequence getTitle() {
        return titleSequence;
    }
}
