package com.pioneer.aaron.qianlilu.Activities;

import android.os.Bundle;

import com.pioneer.aaron.qianlilu.R;

import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by Aaron on 8/7/15.
 */
public class LoginActivity extends SwipeBackActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }

    private void init() {

    }

    @Override
    public void scrollToFinishActivity() {
        super.scrollToFinishActivity();
    }
}