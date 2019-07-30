package com.sargis.kh.android_architecture;

import android.app.Application;
import android.content.Context;

public class App extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        if (context == null) {
            context = getApplicationContext();
        }
    }

    public static Context getAppContext() {
        return context;
    }
}
