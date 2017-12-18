package com.example.android.app.Presenter;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;
import com.example.android.app.Others.User;
import com.example.android.app.View.View;

import java.util.List;

import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;


/**
 * Created by admin on 18.12.2017.
 */

public class UsersListPresenter implements Presenter {

    private Model model = new ModelImpl();
    private Disposable subscription;
    private View view;

    public UsersListPresenter(View view) {
        this.view = view;
    }

    @Override
    public void getData() {

        DisposableObserver observer = new DisposableObserver<List<User>>() {
            @Override
            public void onNext(List<User> users) {
                if(users != null && !users.isEmpty()) {
                    view.showData(users);
                }

            }
            @Override
            public void onError(Throwable e) {
                view.showError(e.getMessage());
            }
            @Override
            public void onComplete() {

            }
        };

        subscription = model.getListOfUsers().
                subscribeWith(observer);
    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
