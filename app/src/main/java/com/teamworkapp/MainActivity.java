package com.teamworkapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("MainActivity", "hello 1");


        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Content-Type", "application/json");
                request.addHeader("Authorization", "BASIC dHdwX292Wnozd1dOTVVmaEk4cm01c0VUU2xXZld3ZHY6eHh4eA==");
                request.addHeader("Accept", "application/json");
            }
        };


        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .setEndpoint(Api.BASE_URL).build();


//        TaskInterface mApi = restAdapter.create(TaskInterface.class);
//        mApi.getTask(new Callback<Task>() {
//            @Override
//            public void success(Task info, Response response) {
//                Task example = info;
//                Log.d("MainActivity", example.getTodoItems().get(0).getStatus());
//
//            }
//
//            @Override
//            public void failure(RetrofitError error) {
//                Log.d("RetrofitError: ", error.getLocalizedMessage());
//            }
//        });


    }
}
