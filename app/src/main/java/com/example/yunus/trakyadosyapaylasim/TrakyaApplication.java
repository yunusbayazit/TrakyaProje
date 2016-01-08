package com.example.yunus.trakyadosyapaylasim;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by yunus on 20.12.2015.
 */
public class TrakyaApplication extends  Application   {
    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

    }
}
