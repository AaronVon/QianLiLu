package com.pioneer.aaron.qianlilu.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.TextView;

import com.pioneer.aaron.qianlilu.R;


/**
 * Created by Aaron on 8/6/15.
 */
public class MainFragment extends Fragment{

    private boolean mSearchCheck;
    public static final String TEXT_FRAGMENT = "txt";

    public static MainFragment newInstance(String text) {
        MainFragment mainFragment = new MainFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TEXT_FRAGMENT, text);
        mainFragment.setArguments(bundle);
        return mainFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_fragment_layout, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.test_textView);
        textView.setText(getArguments().getString(TEXT_FRAGMENT));

        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.menu_search));
        searchView.setQueryHint(this.getString(R.string.search));

        ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text))
                .setHintTextColor(getResources().getColor(R.color.white));
        searchView.setOnQueryTextListener(onQuerySearchListener);

        menu.findItem(R.id.menu_add).setVisible(true);
        menu.findItem(R.id.menu_search).setVisible(true);

        mSearchCheck = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                break;
            case R.id.menu_search:
                mSearchCheck = true;
                break;
        }
        return true;
    }

    private SearchView.OnQueryTextListener onQuerySearchListener = new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            if (mSearchCheck) {
                // TODO: 8/6/15 search
            }
            return false;
        }
    };
}
