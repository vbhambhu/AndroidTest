package com.gochyou.vkumar.gochyou.helpers;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gochyou.vkumar.gochyou.entities.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

public class Helper {


    public static List<Message> getMessages(String sUrl) {

        List<Message> msgs = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            msgs = mapper.readValue(new URL(sUrl), new TypeReference<List<Message>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return msgs;
    }




}
