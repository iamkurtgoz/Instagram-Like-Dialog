package com.iamkurtgoz.instalikedialog_sample;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

public class SampleApp extends Application {

    private static Context context;

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
