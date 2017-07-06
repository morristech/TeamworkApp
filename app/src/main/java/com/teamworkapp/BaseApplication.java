package com.teamworkapp;

import android.app.Application;

import com.teamworkapp.di.component.DaggerTaskComponent;
import com.teamworkapp.di.component.TaskComponent;
import com.teamworkapp.di.module.TaskFetcherModule;
import com.teamworkapp.di.module.TaskModule;


/**
 * @author Tosin Onikute.
 */

public class BaseApplication extends Application {

    public TaskComponent component;

    @Override
    public void onCreate(){
        super.onCreate();

        component = DaggerTaskComponent
                .builder()
                .taskModule(new TaskModule(this))
                .taskFetcherModule(new TaskFetcherModule(this))
                .build();

    }

    public TaskComponent getComponent() {
        return component;
    }

}
