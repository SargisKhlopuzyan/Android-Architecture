package com.sargis.kh.android_architecture.presenter;

import android.os.CountDownTimer;

import com.sargis.kh.android_architecture.App;
import com.sargis.kh.android_architecture.R;
import com.sargis.kh.android_architecture.contract.SearchContract;
import com.sargis.kh.android_architecture.model.SearchDataModel;
import com.sargis.kh.android_architecture.network.call.Data;
import com.sargis.kh.android_architecture.network.call.GetDataCallback;
import com.sargis.kh.android_architecture.network.helper.NetworkHelper;

import java.util.List;

import okhttp3.ResponseBody;

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View viewCallback;

    private CountDownTimer countDownTimer;

    public SearchPresenter(SearchContract.View viewCallback) {
        this.viewCallback = viewCallback;
    }

    @Override
    public void getSearchData(String text) {

        if (text.length() < 3) {
            viewCallback.stopLoadingSearchData();
            destroyTimer();
            return;
        }

        viewCallback.onSearchDataLoadingStarted();

        if (!NetworkHelper.isNetworkActive()) {
            viewCallback.onSearchDataLoadedWithError(App.getAppContext().getString(R.string.no_internet_connection));
            destroyTimer();
            return;
        }

        createTimer(text,500);
    }

    public void createTimer(String text, int screenTimeoutMillis) {
        destroyTimer();
        countDownTimer = new CountDownTimer(screenTimeoutMillis, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                Data.getSearchData(new GetDataCallback<List<SearchDataModel>>() {
                    @Override
                    public void onSuccess(List<SearchDataModel> searchDataModels) {
                        viewCallback.onSearchDataLoaded(searchDataModels);
                    }

                    @Override
                    public void onError(int errorCode, ResponseBody errorResponse) {
                        viewCallback.onSearchDataLoadedWithError(errorResponse.toString());
                    }

                    @Override
                    public void onFailure(Throwable failure) {
                        viewCallback.onSearchDataLoadedWithError(failure.getMessage());
                    }
                }, text);
            }
        };

        countDownTimer.start();
    }

    private void destroyTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
        }
    }

}
