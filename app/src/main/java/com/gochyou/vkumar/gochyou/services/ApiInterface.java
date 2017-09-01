package com.gochyou.vkumar.gochyou.services;

import com.gochyou.vkumar.gochyou.entities.Message;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("inbox.php")
    Call<List<Message>> getInbox();

}