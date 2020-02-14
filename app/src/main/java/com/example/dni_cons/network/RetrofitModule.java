package com.example.dni_cons.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModule {

    public static final String BASE_URL = "https://arturodeveloper.000webhostapp.com/faucet/";
    //public static final String BASE_URL = "http://192.168.1.150:85/faucet/";
    public static Retrofit retrofit;
    private static OkHttpClient.Builder httpClient;
    private HttpLoggingInterceptor loggingInterceptor;


    public static Retrofit getApiClient(){

        List list = Arrays.asList(ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);
        HttpLoggingInterceptor loggingInterceptor;
        loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(loggingInterceptor);
        httpClient.connectionSpecs(list);

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // httpClient.connectTimeout(60, TimeUnit.SECONDS).readTimeout(60,TimeUnit.SECONDS).writeTimeout(60,TimeUnit.SECONDS);
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }

    /*
    private static HttpLoggingInterceptor interceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }*/


}