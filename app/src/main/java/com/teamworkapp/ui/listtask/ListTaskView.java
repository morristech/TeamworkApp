package com.teamworkapp.ui.listtask;

import android.graphics.drawable.Drawable;

import com.teamworkapp.data.model.TodoItem;
import com.teamworkapp.ui.base.MvpView;

import java.util.ArrayList;

/**
 * @author Tosin Onikute.
 */

public interface ListTaskView extends MvpView {

    void init();

    void loadView();

    void taskList();

    void setAdapter(ArrayList<TodoItem> todoItemsList);

    void displayOfflineSnackbar();

    void hideOfflineSnackBar();

    void showLoading();

    void hideLoading();
}
