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
public class CrowdfundFragment extends Fragment {

    public static CrowdfundFragment newInstance() {
        return new CrowdfundFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.crowdfund_layout, container, false);
        loadCrowdFunding();
        return rootView;
    }

    private void loadCrowdFunding() {
        getActivity().setTitle(getString(R.string.crowdfunding));

    }
}
