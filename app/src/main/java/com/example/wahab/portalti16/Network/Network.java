package com.example.wahab.portalti16.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wahab on 10/12/18.
 */

public class Network {
    public  static Retrofit request(){
        return new Retrofit.Builder().baseUrl("http://35.186.145.167:1337/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
