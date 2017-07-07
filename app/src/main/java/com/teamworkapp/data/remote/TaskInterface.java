package com.teamworkapp.data.remote;

import com.teamworkapp.data.model.Task;

import retrofit.Callback;
import retrofit.http.GET;
import rx.Observable;

/**
 * @author Tosin Onikute.
 */

public interface TaskInterface {

    @GET("/tasks.json")
    void getTask(Callback<Task> response);

    @GET("/tasks.json")
    Observable<Task> getAllTask();



}
