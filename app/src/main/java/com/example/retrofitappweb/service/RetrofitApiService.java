package com.example.retrofitappweb.service;

import com.example.retrofitappweb.entity.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitApiService {
    @GET("{id}")
    Call<Message>getMessageId(@Path("id") int id);

    @GET("posts")
    Call<List<Message>> getMessagesUserId(@Query("userId") int userId);

    @GET("ability/?limit=20&offset=20")
    Call<Message> getMessageName();

    @GET("pokemon/{name}")
    Call<List<Message>> getPokemon(@Query("name") String name);
}
