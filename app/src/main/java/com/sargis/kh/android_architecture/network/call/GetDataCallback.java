package com.sargis.kh.android_architecture.network.call;

import okhttp3.ResponseBody;

public interface GetDataCallback<T> {

    void onSuccess(T dataResponse);

    void onError(int errorCode, ResponseBody errorResponse);

    void onFailure(Throwable failure);

}