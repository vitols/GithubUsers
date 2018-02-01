package com.example.android.app.Presenter;;

import com.example.android.app.Model.Model;
import com.example.android.app.Model.ModelImpl;

import io.reactivex.disposables.Disposable;

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
                .filter(repos -> repos!= null && !repos.isEmpty())
                .subscribe(repos -> view.showData(repos), e -> view.showError(e.toString()));
    }

    @Override
    public void onStop() {
        subscription.dispose();
    }
}
