package com.sargis.kh.android_architecture.network.call;

import com.sargis.kh.android_architecture.model.SearchDataModel;
import com.sargis.kh.android_architecture.network.APIService;
import com.sargis.kh.android_architecture.network.RetrofitClientInstance;
import com.sargis.kh.android_architecture.network.helper.UrlHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class AsynchronousRequests {

    public static void getSearchData(GetDataCallback<List<SearchDataModel>> dataCallback, String query) {
        APIService service = RetrofitClientInstance.getRetrofitInstance().create(APIService.class);
        Call<List<SearchDataModel>> call = service.getSearchData(UrlHelper.getDataBySearchQuery(query));
        call.enqueue(new Callback<List<SearchDataModel>>() {
            @Override
            public void onResponse(Call<List<SearchDataModel>> call, retrofit2.Response<List<SearchDataModel>> dataResponse) {
                if (dataResponse.isSuccessful()) {
                    dataCallback.onSuccess(dataResponse.body());
                } else {
                    dataCallback.onError(dataResponse.code(), dataResponse.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<SearchDataModel>> call, Throwable t) {
                dataCallback.onFailure(t);
            }
        });
    }

}
