package com.example.android.app.Presenter;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;
import com.example.android.app.View.ViewUser;

import io.reactivex.disposables.Disposable;


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
                .filter(users -> users != null && !users.isEmpty())
                .subscribe(users -> view.showData(users), e -> view.showError(e.toString()));
    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
