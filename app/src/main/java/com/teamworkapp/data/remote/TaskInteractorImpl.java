package com.teamworkapp.data.remote;

import android.app.Application;
import android.content.Context;

import com.teamworkapp.data.model.Task;

import rx.Observable;
import rx.functions.Func1;


/**
 * @author Tosin Onikute.
 *
 * This is a Data Manager implementer class which contains methods, exposed for all the tasklist related data handling operations
 * to decouple your class, thus making it cleaner and testable
 *
 */

public class TaskInteractorImpl implements TaskInteractor {

    private final Application application;

    public TaskInteractorImpl(Application application) {
        this.application = application;
    }


    public Observable<Task> fetchAllTask(TaskInterface taskInterface){

        return taskInterface.getAllTask()
                .flatMap(new Func1<Task, Observable<Task>>() {
                    @Override
                    public Observable<Task> call(Task countries) {
                        return Observable.just(countries);
                    }
                })
                .onErrorReturn(new Func1<Throwable, Task>() {
                    @Override
                    public Task call(Throwable thr) {
                        return null;
                    }
                });

    }


}
