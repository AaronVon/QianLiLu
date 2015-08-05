package com.pioneer.aaron.qianlilu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import br.liveo.Model.HelpLiveo;
import br.liveo.Model.Navigation;
import br.liveo.interfaces.OnItemClickListener;
import br.liveo.interfaces.OnPrepareOptionsMenuLiveo;
import br.liveo.navigationliveo.NavigationLiveo;

public class MainActivity extends NavigationLiveo implements OnItemClickListener {

    private HelpLiveo navi_drawer;

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


    }

    @Override
    public void onItemClick(int position) {

    }

    private OnPrepareOptionsMenuLiveo onPrepare = new OnPrepareOptionsMenuLiveo() {
        @Override
        public void onPrepareOptionsMenu(Menu menu, int position, boolean visible) {
        }
    };

    private View.OnClickListener onClickPhoto = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "click on thumbnail of user", Toast.LENGTH_SHORT).show();
            closeDrawer();
        }
    };

    private View.OnClickListener onClickFooter = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "click on footer", Toast.LENGTH_SHORT).show();

            closeDrawer();
        }
    };
}
