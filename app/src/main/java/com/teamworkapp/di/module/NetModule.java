package com.teamworkapp.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


import com.google.gson.GsonBuilder;
import com.teamworkapp.Api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * @author Tosin Onikute.
 */

@Module
public class NetModule {

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    RestAdapter provideRestAdapter() {

        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestInterceptor.RequestFacade request) {
                request.addHeader("Content-Type", "application/json");
                request.addHeader("Authorization", "BASIC dHdwX292Wnozd1dOTVVmaEk4cm01c0VUU2xXZld3ZHY6eHh4eA==");
                request.addHeader("Accept", "application/json");
            }
        };

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(Api.BASE_URL)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(new GsonBuilder().create()))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        return restAdapter;
    }


}
