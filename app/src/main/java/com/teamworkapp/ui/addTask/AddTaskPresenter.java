package com.teamworkapp.ui.addTask;

import android.app.Application;

import com.teamworkapp.data.model.Project;
import com.teamworkapp.data.model.Projects;
import com.teamworkapp.data.model.TaskUpdate;
import com.teamworkapp.data.remote.TaskInteractor;
import com.teamworkapp.data.remote.TaskInterface;
import com.teamworkapp.ui.base.BasePresenter;
import com.teamworkapp.util.Logger;

import java.util.ArrayList;
import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author Tosin Onikute.
 */

public class AddTaskPresenter extends BasePresenter<AddTaskView>{

    private final Application application;
    private AddTaskView addTaskView;
    private Logger logger = Logger.getLogger(getClass());

    TaskInteractor taskInteractor;


    public AddTaskPresenter(Application application, TaskInteractor taskInteractor) {
        this.application = application;
        this.taskInteractor = taskInteractor;
    }

    @Override
    public void attachView(AddTaskView addTaskView){
        super.attachView(addTaskView);
    }

    @Override
    public void detachView(){
        super.detachView();
    }

    public void addTaskList(TaskInterface taskInterface, TaskUpdate taskUpdate, String id){

        getMvpView().showLoading();
        taskInteractor.addTask(taskInterface, taskUpdate, id);

    }


    public void getProjectList(TaskInterface taskInterface, CompositeSubscription mCompositeSubscription){

        mCompositeSubscription.add(taskInteractor.fetchAllProject(taskInterface)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Projects>() {
                    @Override
                    public void call(Projects posts) {

                        List<Project> arr = posts.getProjects();

                        ArrayList<Project> projectItemList = new ArrayList<Project>(arr);
                        getMvpView().setProjectName(projectItemList);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.debug(throwable.getLocalizedMessage());
                    }
                }));

    }




}