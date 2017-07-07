package com.teamworkapp.data.remote;

import com.teamworkapp.data.model.Task;
import com.teamworkapp.data.model.TaskUpdate;

import rx.Observable;

/**
 * @author Tosin Onikute.
 *
 * TaskInteractor is an interface that is implemented by the TaskInteractorImpl Data Manager
 *
 */

public interface TaskInteractor {

    Observable<Task> fetchAllTask(TaskInterface taskInterface);

    void updateTask(TaskInterface taskInterface, TaskUpdate taskUpdate, String id);

}
