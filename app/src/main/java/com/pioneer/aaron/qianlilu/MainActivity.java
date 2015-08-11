package com.pioneer.aaron.qianlilu;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.pioneer.aaron.qianlilu.Activities.LoginActivity;
import com.pioneer.aaron.qianlilu.Activities.MoreActivity;
import com.pioneer.aaron.qianlilu.Fragments.CrowdfundFragment;
import com.pioneer.aaron.qianlilu.Fragments.InboxFragment;
import com.pioneer.aaron.qianlilu.Fragments.HomeFragment;
import com.pioneer.aaron.qianlilu.Fragments.PioneerFragment;
import com.pioneer.aaron.qianlilu.Fragments.RecommendFragment;

import br.liveo.Model.HelpLiveo;
import br.liveo.Model.Navigation;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo navi_drawer;
    long exitTime = 0;//calculate time to exit

    @Override
    public void onInt(Bundle bundle) {
        //User Info
        this.userName.setText(R.string.userName);
        this.userPhoto.setImageResource(R.drawable.thumbnail);
        //this.userBackground.setImageResource();

        //Items Navigation
        navi_drawer = new HelpLiveo();
        navi_drawer.add(getString(R.string.inbox), R.mipmap.ic_textsms_black_24dp); //icon to be added
        navi_drawer.addSubHeader(getString(R.string.blink));
        navi_drawer.add(getString(R.string.homepage), R.mipmap.ic_home_black_24dp);
        navi_drawer.add(getString(R.string.recom), R.mipmap.ic_star_black_24dp);
        navi_drawer.add(getString(R.string.crowdfunding), R.mipmap.ic_people_black_24dp);
        navi_drawer.addSeparator();

        with(this, Navigation.THEME_DARK)
                .startingPosition(2)
                .addAllHelpItem(navi_drawer.getHelp())
                .colorNameSubHeader(R.color.colorNameSubHeader)
                .colorItemSelected(R.color.colorItemSelected)
                .footerItem(getString(R.string.more), R.mipmap.ic_unfold_less_black_24dp)
                .setOnClickUser(onClickPhoto)
                .setOnPrepareOptionsMenu(onPrepare)
                .setOnClickFooter(onClickFooter)
                .build();

        int position = this.getCurrentPosition();
        this.setElevationToolBar(position != 2 ? 15 : 0);

    }

    @Override
    public void onItemClick(int position) {
        Fragment fragment = null;
        FragmentManager fragmentManager = getSupportFragmentManager();

        switch (position) {
            case 0:
                fragment = InboxFragment.newInstance();
                break;

            case 2:
                fragment = HomeFragment.newInstance();
                break;

            case 3:
                fragment = RecommendFragment.newInstance();
                break;

            case 4:
                fragment = CrowdfundFragment.newInstance();
                break;

        }
        if (fragment != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
        setElevationToolBar(position != 2 ? 15 : 0);
    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.keep);
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, MoreActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.in_from_right, R.anim.keep);
            closeDrawer();
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                this.exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
