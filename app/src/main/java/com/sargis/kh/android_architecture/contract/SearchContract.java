package com.sargis.kh.android_architecture.contract;

import com.sargis.kh.android_architecture.model.SearchDataModel;

import java.util.List;

public interface SearchContract {

    interface View {
        void onSearchDataLoadingStarted();
        void onSearchDataLoaded(List<SearchDataModel> searchDataModels);
        void onSearchDataLoadedWithError(String errorMessage);

        void stopLoadingSearchData();
    }

    interface Presenter {
        void getSearchData(String text);
    }

}
