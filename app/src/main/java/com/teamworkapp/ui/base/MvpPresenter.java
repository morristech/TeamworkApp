package com.teamworkapp.ui.base;

/**
 * @author Tosin Onikute.
 */

public interface MvpPresenter<V extends MvpView> {

    void attachView(V mvpView);

    void detachView();
}
