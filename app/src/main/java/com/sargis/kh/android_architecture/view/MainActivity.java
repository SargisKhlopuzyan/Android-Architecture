package com.sargis.kh.android_architecture.view;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.sargis.kh.android_architecture.R;
import com.sargis.kh.android_architecture.adapter.SearchAdapter;
import com.sargis.kh.android_architecture.contract.SearchContract;
import com.sargis.kh.android_architecture.databinding.ActivityMainBinding;
import com.sargis.kh.android_architecture.model.SearchDataModel;
import com.sargis.kh.android_architecture.presenter.SearchPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchContract.View, SearchAdapter.SearchItemSelectedInterface {

    private ActivityMainBinding binding;

    private SearchContract.Presenter searchPresenter;
    private SearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setSupportActionBar(binding.toolbar);

        searchPresenter = new SearchPresenter(this);

        setupRecyclerViewSearch();
        setListeners();
    }

    private void setupRecyclerViewSearch() {
        searchAdapter = new SearchAdapter(this);
        binding.recyclerViewSearch.setHasFixedSize(false);
        binding.recyclerViewSearch.setAdapter(searchAdapter);
    }

    private void setListeners() {

        binding.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                binding.searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                hideErrorMessage();
                searchPresenter.getSearchData(newText);
                return false;
            }
        });

        binding.setOnQueryTextFocusChangeListener((v, hasFocus) -> {
            invalidateOptionsMenu();
            if (hasFocus) {
            } else if (String.valueOf(((SearchView)v).getQuery()).isEmpty()){
                binding.searchView.setIconified(true);
            }
        });
    }

    @Override
    public void onSearchDataLoadingStarted() {
        searchAdapter.clearData();
        binding.setIsSearchLoading(true);
        hideErrorMessage();
    }

    @Override
    public void onSearchDataLoaded(List<SearchDataModel> searchDataModels) {
        binding.setIsSearchLoading(false);
        hideErrorMessage();
        searchAdapter.updateData(searchDataModels);
    }

    @Override
    public void onSearchDataLoadedWithError(String errorMessage) {
        binding.setIsSearchLoading(false);
        showErrorMessage(errorMessage);
    }

    @Override
    public void stopLoadingSearchData() {
        binding.setIsSearchLoading(false);
        searchAdapter.clearData();
    }

    @Override
    public void onSearchItemClicked(SearchDataModel searchDataModel) {
        searchAdapter.clearData();
    }

    private void showErrorMessage(String errorMessage) {
        binding.setIsErrorVisible(true);
        binding.setErrorMessage(errorMessage);
    }

    private void hideErrorMessage() {
        binding.setIsErrorVisible(false);
        binding.setErrorMessage("");
    }

}
