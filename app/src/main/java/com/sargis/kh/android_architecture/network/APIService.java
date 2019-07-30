package com.sargis.kh.android_architecture.network;

import com.sargis.kh.android_architecture.model.SearchDataModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIService {

    @GET
    Call<List<SearchDataModel>> getSearchData(@Url String url);

}
