package com.example.baytalhekma.api;

import androidx.annotation.NonNull;

import com.example.baytalhekma.Models.RegisterModel;
import com.example.baytalhekma.Models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Userclient {

    @NonNull
    @FormUrlEncoded
    @POST("register")
    Call<RegisterModel> register (@Field("name") String name,
                                  @Field("email") String email,
                                  @Field("password") String password,
                                  @Field("mobile") String mobile,
                                  @Field("college_id") String college_id);

    @FormUrlEncoded
    @POST("login")
    Call<RegisterModel> login (@Field("login") String name,
                                  @Field("password") String password);

    @FormUrlEncoded
    @GET("packages")
    Call<RegisterModel> getPacks ();

    @GET("verifyOtp/{otp}")
    Call<RegisterModel> otpVerify (@Path("otp") int otp, @Header("Authorization") String auth);

    //2319|cgecO4eQRNsWB06K5nFuGylrNoSCdWLH8QWS67J5
}
