package com.sargis.kh.android_architecture.network.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sargis.kh.android_architecture.App;

public class NetworkHelper {
    public static boolean isNetworkActive() {
        ConnectivityManager connMgr = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}
