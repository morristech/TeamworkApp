package com.teamworkapp.data.remote;

import android.app.Application;
import android.content.Context;

/**
 * @author Tosin Onikute.
 */

public class TaskFetcherImpl implements TaskFetcher {

    private final Application application;

    public TaskFetcherImpl(Application application) {
        this.application = application;
    }

    public String sayHelloFetcher(Context context, String str){
        String newString = str + " + Hello Android ! ";
        return newString;
    }


}
