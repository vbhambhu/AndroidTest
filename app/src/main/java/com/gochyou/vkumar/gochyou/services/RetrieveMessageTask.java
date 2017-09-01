package com.gochyou.vkumar.gochyou.services;

import android.os.AsyncTask;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gochyou.vkumar.gochyou.entities.Message;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vkumar on 30/08/2017.
 */

public class RetrieveMessageTask extends AsyncTask<String, Void, List<Message>> {


    @Override
    protected List<Message> doInBackground(String... urls) {
        List<Message> msgs = new ArrayList<>();

        try {
            URL url = new URL(urls[0]);
            ObjectMapper mapper = new ObjectMapper();
            msgs = mapper.readValue(url, new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msgs;
    }
}
