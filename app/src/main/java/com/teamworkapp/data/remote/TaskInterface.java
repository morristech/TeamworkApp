package com.teamworkapp.data.remote;

import com.teamworkapp.data.model.project.Projects;
import com.teamworkapp.data.model.task.NewTask;
import com.teamworkapp.data.model.task.Task;
import com.teamworkapp.data.model.task.TaskUpdate;
import com.teamworkapp.data.model.tasklist.Tasklists;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
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

    @POST("/tasklists/{id}/tasks.json")
    void addTask(@Path("id") String id, @Body NewTask body, Callback<Task> response);

    @GET("/projects.json?status=ALL")
    Observable<Projects> getAllProject();

    /* /projects/{project_id}/tasklists.json */
    @GET("/projects/{id}/tasklists.json")
    Observable<Tasklists> getTasklist(@Path("id") String id);


}
