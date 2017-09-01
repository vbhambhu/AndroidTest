package com.gochyou.vkumar.gochyou;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.gochyou.vkumar.gochyou.entities.Message;
import com.gochyou.vkumar.gochyou.helpers.Helper;
import com.gochyou.vkumar.gochyou.services.ApiClient;
import com.gochyou.vkumar.gochyou.services.ApiInterface;
import com.gochyou.vkumar.gochyou.services.RetrieveMessageTask;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MessageFragment extends Fragment {
    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("MessageFragment is creating");

        test();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    public void test() {

        System.out.println("start");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Message>> call = apiService.getInbox();

        call.enqueue(new Callback<List<Message>>() {

            @Override
            public void onResponse(Call<List<Message>> call, retrofit2.Response<List<Message>> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
//                swipeRefreshLayout.setRefreshing(false);
            }
        });



        //Volley.newRequestQueue(this).add(stringRequest);

//        AsyncTask<String, Void, List<Message>> messages = new RetrieveMessageTask().execute("http://10.0.2.2/guesswho/index.php");
//        System.out.println("====================");
//        System.out.println(messages.toString());










    }
}
