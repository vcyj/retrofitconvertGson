package com.example.retrofitsimpledemo;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface MyApi {
    @GET("index")
    Call<ResponseBody> getToutiao(@Query("type") String type,@Query("key")String key);
    @GET("index")
    Call<TopInfo> getTop(@Query("type") String type,@Query("key")String key);
}
