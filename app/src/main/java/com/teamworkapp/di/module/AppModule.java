package com.teamworkapp.di.module;

import android.app.Application;

import com.teamworkapp.data.remote.TaskInteractor;
import com.teamworkapp.data.remote.TaskInteractorImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author Tosin Onikute.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    TaskInteractor provideDataManager(TaskInteractorImpl appDataManager) {
        return appDataManager;
    }
}