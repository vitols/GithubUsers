package com.example.android.app.Presenter;

import android.util.Log;
import android.view.View;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

import com.example.android.app.Others.Repo;
import com.example.android.app.Others.User;

import java.util.List;

/**
 * Created by admin on 21.01.2018.
 */

public class ReposListPresenter implements Presenter {

    private Model model = new ModelImpl();
    private Disposable subscription;
    private com.example.android.app.View.ViewRepo view;
    private String userName;

    public ReposListPresenter(com.example.android.app.View.ViewRepo view, String userName) {
        this.view = view;
        this.userName = userName;
    }

    @Override
    public void getData() {

        subscription = model.getListOfRepositories(userName)
                .filter(repos -> repos!= null)
                .filter(repos -> !repos.isEmpty())
                .subscribe(repos -> view.showData(repos), e -> view.showError(e.toString()));
    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
