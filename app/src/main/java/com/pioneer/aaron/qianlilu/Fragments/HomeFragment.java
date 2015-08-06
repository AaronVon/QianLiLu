package com.pioneer.aaron.qianlilu.Fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pioneer.aaron.qianlilu.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aaron on 8/6/15.
 */
public class HomeFragment extends Fragment {
    private List<TabPagerItem> mTabItems = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createTabPagerItem();
    }

    private void createTabPagerItem() {
        mTabItems.add(new TabPagerItem(getString(R.string.TGU), MainFragment.newInstance(getString(R.string.TGU))));
        mTabItems.add(new TabPagerItem(getString(R.string.TRU), MainFragment.newInstance(getString(R.string.TRU))));
        mTabItems.add(new TabPagerItem(getString(R.string.TSU), MainFragment.newInstance(getString(R.string.TSU))));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_viewpager, container, false);
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewPager);

        //this param may change with system performance limit
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), mTabItems));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tabLayout.setElevation(10);
        }
        tabLayout.setupWithViewPager(viewPager);
    }
}
