package com.teamworkapp.ui.addTask;

import android.app.Application;
import android.content.Context;

import com.teamworkapp.data.model.project.Project;
import com.teamworkapp.data.model.project.Projects;
import com.teamworkapp.data.model.task.NewTask;
import com.teamworkapp.data.model.tasklist.Tasklist;
import com.teamworkapp.data.model.tasklist.Tasklists;
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

    public void addTaskList(TaskInterface taskInterface, NewTask newTask, String id, Context context){

        getMvpView().showLoading();
        taskInteractor.addTask(taskInterface, newTask, id, context);

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


    public void getTaskList(TaskInterface taskInterface, CompositeSubscription mCompositeSubscription, String projectId){

        mCompositeSubscription.add(taskInteractor.fetchTaskList(taskInterface, projectId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Tasklists>() {
                    @Override
                    public void call(Tasklists posts) {

                        List<Tasklist> arr = posts.getTasklists();

                        ArrayList<Tasklist> tasklistItem = new ArrayList<Tasklist>(arr);
                        getMvpView().setTaskLists(tasklistItem);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.debug(throwable.getLocalizedMessage());
                    }
                }));

    }




}
