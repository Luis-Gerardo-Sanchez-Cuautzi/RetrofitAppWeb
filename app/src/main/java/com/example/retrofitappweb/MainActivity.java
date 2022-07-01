package com.example.retrofitappweb;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitappweb.client.RetrofitClient;
import com.example.retrofitappweb.databinding.ActivityMainBinding;
import com.example.retrofitappweb.entity.Message;
import com.example.retrofitappweb.service.RetrofitApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity {

    private TextView mTextView;
    private ActivityMainBinding binding;
    private RetrofitApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initView();
        iniValues();

        getUser();
    }

    private void initView(){
        mTextView = binding.messTextView;
    }

    private void iniValues(){
        apiService = RetrofitClient.getApiService();
    }


    private void  getUser(){
        apiService.getMessageName().enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message resp = response.body();
                mTextView.setText(resp.toString());
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                mTextView.setText(t.getMessage());
            }
        });
    }
}