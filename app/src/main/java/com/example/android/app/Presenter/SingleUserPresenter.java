package com.example.android.app.Presenter;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;
import com.example.android.app.View.ViewSingleUser;

import io.reactivex.disposables.Disposable;

/**
 * Created by admin on 21.01.2018.
 */

public class SingleUserPresenter implements PresenterUser {

    private Model model = new ModelImpl();
    private Disposable subscription;
    private ViewSingleUser view;

    public SingleUserPresenter(ViewSingleUser view) {
        this.view = view;
    }

    @Override
    public void getData(String userName, final int position) {
        subscription = model.getSingleUser(userName).
                subscribe(user -> view.showData(user, position), e -> view.showError(e.toString()));
    }

    @Override
    public void getData() {

    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
