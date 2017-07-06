package com.teamworkapp.di.module;

import android.app.Application;

import com.teamworkapp.data.remote.TaskFetcher;
import com.teamworkapp.data.remote.TaskFetcherImpl;
import com.teamworkapp.ui.listtask.ListTaskPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * @author Tosin Onikute.
 */

@Module
public class TaskModule {

    private Application application;

    public TaskModule(Application application){
        this.application = application;
    }

    @Provides
    public ListTaskPresenter getHelloPresenter(TaskFetcher taskFetcher){
        return new ListTaskPresenter(application, taskFetcher);
    }


    @Provides
    TaskFetcher provideHelloFetcher() {
        return new TaskFetcherImpl( application );
    }



}
