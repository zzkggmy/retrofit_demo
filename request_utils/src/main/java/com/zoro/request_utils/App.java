package com.zoro.request_utils;

import android.app.Application;

import com.zoro.request_utils.api.RequestUtil;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RequestUtil.getInstance().init();
    }
}
