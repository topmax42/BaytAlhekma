package com.example.baytalhekma.api;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;




    public class RetrofitClientS {

        private static RetrofitClientS instance = null;
        private Userclient myApi;

        private RetrofitClientS() {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            OkHttpClient okHttpClient = new OkHttpClient.Builder()

                    .addInterceptor(loggingInterceptor)
                    .addInterceptor(chain -> {
                        Request.Builder requestBuilder = chain.request().newBuilder();
                        requestBuilder.header("Content-Type", "application/json");
                        requestBuilder.header("Accept", "application/json");
                        return chain.proceed(requestBuilder.build());
                    })
                    .readTimeout(60, TimeUnit.SECONDS)
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .writeTimeout(60, TimeUnit.SECONDS)
                    .build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://v2.baytelhekma.tk/api/")
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();
            myApi = retrofit.create(Userclient.class);
        }

        public static synchronized RetrofitClientS getInstance() {
            if (instance == null) {
                instance = new RetrofitClientS();
            }
            return instance;
        }

        public Userclient getMyApi() {
            return myApi;
        }
    }

