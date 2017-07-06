package com.teamworkapp.ui.listtask;

import android.app.Application;
import android.graphics.drawable.Drawable;

import com.teamworkapp.data.remote.TaskFetcher;
import com.teamworkapp.ui.base.BasePresenter;

/**
 * @author Tosin Onikute.
 */

public class ListTaskPresenter extends BasePresenter<ListTaskView>{

    private final Application application;
    private ListTaskView listTaskView;

    TaskFetcher taskFetcher;


    public ListTaskPresenter(Application application, TaskFetcher taskFetcher) {
        this.application = application;
        this.taskFetcher = taskFetcher;
    }

    @Override
    public void attachView(ListTaskView listTaskView){
        super.attachView(listTaskView);
    }

    @Override
    public void detachView(){
        super.detachView();
    }




}
