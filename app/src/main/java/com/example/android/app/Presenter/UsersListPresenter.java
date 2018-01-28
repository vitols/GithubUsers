package com.example.android.app.Presenter;

import android.util.Log;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;
import com.example.android.app.Others.User;
import com.example.android.app.View.View;
import com.example.android.app.View.ViewUser;

import java.util.List;
import io.reactivex.Observable;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.Response;


/**
 * Created by admin on 18.12.2017.
 */

public class UsersListPresenter implements Presenter {

    private Model model = new ModelImpl();
    private Disposable subscription;
    private ViewUser view;

    public UsersListPresenter(ViewUser view) {
        this.view = view;
    }

    @Override
    public void getData() {

        subscription = model.getListOfUsers()
                .filter(users -> users != null)
                .filter(users -> !users.isEmpty())
                .subscribe(users -> view.showData(users), e -> view.showError(e.toString()));
    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
