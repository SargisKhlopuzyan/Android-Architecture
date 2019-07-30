package com.sargis.kh.android_architecture.network.call;

import com.sargis.kh.android_architecture.model.SearchDataModel;

import java.util.List;

public class Data {

    public static void getSearchData(GetDataCallback<List<SearchDataModel>> dataCallback, String query) {
        AsynchronousRequests.getSearchData(dataCallback, query);
    }

}