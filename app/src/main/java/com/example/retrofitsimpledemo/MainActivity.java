package com.example.retrofitsimpledemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    /**
     * 0:头条
     * 1:社会
     * 2:国内新闻
     * 3:国际新闻
     */
    String BASE_URL="http://v.juhe.cn/toutiao/";
    String key="8127e7fe2a81c92a11a7eb46b09a4c81";
    String type[]={"top","shehui","guonei","guoji"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Retrofit retrofit=new Retrofit.Builder()
//                .baseUrl("http://v.juhe.cn/toutiao/")
//                .build();
//        MyApi service1=retrofit.create(MyApi.class);
//        Call<ResponseBody>toutiao =service1.getToutiao(type[1],key);
//        toutiao.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    String str=response.body().string();
//                    //System.out.println("返回数据"+str);
//                    TopInfo top=new Gson().fromJson(str,TopInfo.class);
//                    System.out.println("jeeyu"+top.getResult().getClass());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//        new Thread(){
//            @Override
//            public void run() {
//
//            }
//        }.start();
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        MyApi api=retrofit.create(MyApi.class);
        Call<TopInfo>top=api.getTop(type[1],key);
        top.enqueue(new Callback<TopInfo>() {
            @Override
            public void onResponse(Call<TopInfo> call, Response<TopInfo> response) {
                System.out.println("jeeyu"+response.body().getResult().getData().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<TopInfo> call, Throwable t) {

            }
        });
    }


}