package com.teamworkapp.data.remote;

import android.content.Context;

import com.teamworkapp.data.model.Task;

import rx.Observable;

/**
 * @author Tosin Onikute.
 *
 * TaskInteractor is an interface that is implemented by the TaskInteractorImpl Data Manager
 *
 */

public interface TaskInteractor {

    Observable<Task> fetchAllTask(TaskInterface taskInterface);

}
