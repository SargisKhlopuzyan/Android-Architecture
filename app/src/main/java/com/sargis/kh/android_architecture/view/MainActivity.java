package com.sargis.kh.android_architecture.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import com.sargis.kh.android_architecture.R;
import com.sargis.kh.android_architecture.databinding.ActivityMainBinding;
import com.sargis.kh.android_architecture.viewmodel.MVVM_ViewModel;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MVVM_ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MVVM_ViewModel.class);
        viewModel.init();
        binding.setMvvmViewModel(viewModel);
    }
}
