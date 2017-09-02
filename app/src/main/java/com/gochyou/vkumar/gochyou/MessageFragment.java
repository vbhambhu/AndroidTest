package com.gochyou.vkumar.gochyou;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
import com.gochyou.vkumar.gochyou.extras.MessageRVAdapter;
import com.gochyou.vkumar.gochyou.services.ApiClient;
import com.gochyou.vkumar.gochyou.services.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MessageFragment extends Fragment {

    private Context mContext;
    RecyclerView recyclerView;

    private static final String ENDPOINT = "http://10.0.2.2/gochyouapi/message/list?userid=1";
    List<Message> msgs = new ArrayList<Message>();
    private RequestQueue requestQueue;
    private Gson gson;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext=context;
    }

    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestQueue = Volley.newRequestQueue(this.mContext);
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();
        fetchMessages();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_message, container, false);
        recyclerView = view.findViewById(R.id.rvMessages);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity())); //set layoutManger

        return view;
    }

    private void fetchMessages() {
        System.out.println("Now in fetchMessages");
        StringRequest request = new StringRequest(Request.Method.GET, ENDPOINT, onPostsLoaded, onPostsError);
        requestQueue.add(request);
    }

    private final Response.Listener<String> onPostsLoaded = new Response.Listener<String>() {

        @Override
        public void onResponse(String response) {
            System.out.println(response);
            msgs = Arrays.asList(gson.fromJson(response, Message[].class));
            MessageRVAdapter mAdapter = new MessageRVAdapter(msgs);//create an adapter
            recyclerView.setAdapter(mAdapter);  // set adapter
        }
    };

    private final Response.ErrorListener onPostsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            System.out.println("Messages load fail");
            Log.e("PostActivity", error.toString());
        }
    };

}
