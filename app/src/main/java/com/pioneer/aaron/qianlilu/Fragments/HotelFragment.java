package com.pioneer.aaron.qianlilu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pioneer.aaron.qianlilu.R;
import com.pioneer.aaron.qianlilu.Utilities.LocationUtil;

/**
 * Created by Aaron on 8/10/15.
 */
public class HotelFragment extends Fragment {

    public static HotelFragment newInstance() {
        return new HotelFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.hotel_layout, container, false);
        loadHotel();
        return rootView;
    }

    private void loadHotel() {
        new LocationUtil(getActivity());
    }
}
