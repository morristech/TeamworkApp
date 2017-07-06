package com.teamworkapp.ui.listtask;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.teamworkapp.BaseApplication;
import com.teamworkapp.R;
import com.teamworkapp.di.component.TaskComponent;
import com.teamworkapp.ui.base.BaseActivity;

import javax.inject.Inject;

public class ListTaskActivity extends BaseActivity implements ListTaskView {

    @Inject
    ListTaskPresenter presenter;


    @Override
    protected void setupActivity(TaskComponent component, Bundle savedInstanceState) {
        setContentView(R.layout.activity_list_task);
        ((BaseApplication) getApplication()).getComponent().inject(this);

        presenter.attachView(this);





    }



    @Override
    public void showLoading(){

    }

    @Override
    public void hideLoading(){

    }








}
