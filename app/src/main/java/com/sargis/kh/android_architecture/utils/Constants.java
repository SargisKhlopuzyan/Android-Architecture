package com.sargis.kh.android_architecture.utils;

public interface Constants {

    interface UrlConstants {
        String BASE_URL = "https://api.apixu.com/v1/";
        String SEARCH_URL = BASE_URL + "search.json?key=" + ApiConstants.API_KEY + "&q=";
    }

    interface ApiConstants {
        String API_KEY = "65c8401892bc4738b3d104240192006";
    }

}