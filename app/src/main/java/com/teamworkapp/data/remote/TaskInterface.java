package com.teamworkapp.data.remote;

import com.teamworkapp.data.model.Task;
import com.teamworkapp.data.model.TaskUpdate;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.PUT;
import retrofit.http.Path;
import rx.Observable;

/**
 * @author Tosin Onikute.
 */

public interface TaskInterface {

    @GET("/tasks.json")
    void getTask(Callback<Task> response);

    @GET("/tasks.json")
    Observable<Task> getAllTask();


    @PUT("/tasks/{id}.json")
    void editTask(@Path("id") String id, @Body TaskUpdate body, Callback<Task> response);


}
