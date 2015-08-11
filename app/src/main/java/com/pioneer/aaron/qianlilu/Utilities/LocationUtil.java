package com.pioneer.aaron.qianlilu.Utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.Poi;

import java.util.List;

/**
 * Created by Aaron on 8/11/15.
 */
public class LocationUtil {

    private LocationClient mLocationClient;

    public LocationUtil(final Context context) {
        mLocationClient = new LocationClient(context);
        setLocationOption();
        mLocationClient.registerLocationListener(new BDLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation location) {
                //get current city
                Log.d("location~~~~", location.getCity());
            }
        });
        mLocationClient.start();
    }

    private void setLocationOption() {
        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(Constans.locationMode);
        option.setCoorType(Constans.CoorType);
        option.setScanSpan(Constans.span);
        option.setIsNeedAddress(true);
        option.setOpenGps(true);
        option.setLocationNotify(true);
        option.setIgnoreKillProcess(true);
        option.setEnableSimulateGps(true);
        option.setIsNeedLocationDescribe(true);
        option.setIsNeedLocationPoiList(false);

        mLocationClient.setLocOption(option);
    }
}
