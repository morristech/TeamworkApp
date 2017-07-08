package com.teamworkapp.ui.addTask;

import com.teamworkapp.data.model.project.Project;
import com.teamworkapp.ui.base.MvpView;

import java.util.ArrayList;

/**
 * @author Tosin Onikute.
 */

public interface AddTaskView extends MvpView {

    void init();

    void loadView();

    void setProjectName(ArrayList<Project> projectNames);

    void displayOfflineSnackbar();

    void hideOfflineSnackBar();

    void showLoading();

    void hideLoading();
}
