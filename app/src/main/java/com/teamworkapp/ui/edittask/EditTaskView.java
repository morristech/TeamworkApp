package com.teamworkapp.ui.edittask;

import com.teamworkapp.ui.base.MvpView;

/**
 * @author Tosin Onikute.
 */

public interface EditTaskView extends MvpView {

    void init();

    void loadView();

    void displayOfflineSnackbar();

    void hideOfflineSnackBar();

    void showLoading();

    void hideLoading();
}
