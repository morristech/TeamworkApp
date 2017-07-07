package com.teamworkapp.ui.edittask;

import android.app.Application;

import com.teamworkapp.data.model.TaskUpdate;
import com.teamworkapp.data.remote.TaskInteractor;
import com.teamworkapp.data.remote.TaskInterface;
import com.teamworkapp.ui.base.BasePresenter;
import com.teamworkapp.ui.listtask.ListTaskView;
import com.teamworkapp.util.Logger;

/**
 * @author Tosin Onikute.
 */

public class EditTaskPresenter extends BasePresenter<EditTaskView>{

    private final Application application;
    private ListTaskView listTaskView;
    private Logger logger = Logger.getLogger(getClass());

    TaskInteractor taskInteractor;


    public EditTaskPresenter(Application application, TaskInteractor taskInteractor) {
        this.application = application;
        this.taskInteractor = taskInteractor;
    }

    @Override
    public void attachView(EditTaskView editTaskView){
        super.attachView(editTaskView);
    }

    @Override
    public void detachView(){
        super.detachView();
    }

    public void updateTaskList(TaskInterface taskInterface, TaskUpdate taskUpdate, String id){

        getMvpView().showLoading();
        taskInteractor.updateTask(taskInterface, taskUpdate, id);

    }




}
