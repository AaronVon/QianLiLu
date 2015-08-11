package com.pioneer.aaron.qianlilu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.pioneer.aaron.qianlilu.R;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

/**
 * Created by Aaron on 8/9/15.
 */
public class InboxFragment extends Fragment {

    private PullToRefreshListView pullToRefreshListView;

    public static InboxFragment newInstance() {
        return new InboxFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.inbox_layout, container, false);
        pullToRefreshListView = (PullToRefreshListView) rootView.findViewById(R.id.pull_refresh_list);
        loadInbox();

        return rootView;
    }

    private void loadInbox() {

        //set the title which displays in action bar
        getActivity().setTitle(getString(R.string.inbox));

        // TODO: 8/9/15 handle data

        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {

            }
        });
    }
}
