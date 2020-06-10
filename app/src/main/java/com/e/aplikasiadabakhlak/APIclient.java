package com.e.aplikasiadabakhlak;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIclient {

    //public static final String BASE_URL = "http://192.168.43.156/PhpAdabAkhlak/";
    public static final String BASE_URL = "http://mobileprog.lkp2i.co.id/f4_adabakhlaq/";
    private static Retrofit retrofit;

    static Retrofit getApiClient(){
        if (retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
