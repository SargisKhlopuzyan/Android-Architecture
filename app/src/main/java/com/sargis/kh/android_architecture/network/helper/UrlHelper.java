package com.sargis.kh.android_architecture.network.helper;

import com.sargis.kh.android_architecture.utils.Constants;

public class UrlHelper {

    public static String getDataBySearchQuery(String query) {
        String url = Constants.UrlConstants.SEARCH_URL + query;
        return url;
    }

}
