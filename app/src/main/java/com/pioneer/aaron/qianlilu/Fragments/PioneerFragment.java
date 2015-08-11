package com.pioneer.aaron.qianlilu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pioneer.aaron.qianlilu.R;

/**
 * Created by Aaron on 8/10/15.
 */
public class PioneerFragment extends Fragment {

    public static PioneerFragment newInstance() {
        return new PioneerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.pioneer_layout, container, false);
        loadPioneer();
        return rootView;
    }

    private void loadPioneer() {

    }
}
