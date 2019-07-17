package com.sargis.kh.android_architecture.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.sargis.kh.android_architecture.R;
import com.sargis.kh.android_architecture.contract.MVPContract;
import com.sargis.kh.android_architecture.databinding.ActivityMainBinding;
import com.sargis.kh.android_architecture.presenter.MVPPresenter;

public class MainActivity extends AppCompatActivity implements MVPContract.View {

    private MVPContract.Presenter presenter;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        presenter = new MVPPresenter(this);

        binding.setOnShowClickListener(v -> presenter.loadMessage());

        binding.setOnUpdateClickListener(v -> presenter.saveName(binding.textViewFirstName.getText().toString(), binding.textViewLastName.getText().toString()));
    }

    @Override
    public void showMessage(String message) {
        binding.setMessage(message);
    }

    @Override
    public void showError(String error) {
        binding.setMessage("");
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }
}
