package com.example.android.app.Model;

import com.example.android.app.Others.User;
import com.example.android.app.githubAPI.GitHubApi;
import com.example.android.app.githubAPI.GitHubApiInterface;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;

/**
 * Created by admin on 17.12.2017.
 */

public class ModelImpl implements Model {

    private static GitHubApiInterface apiInterface = GitHubApi.getApiInterface("https://api.github.com");


    @Override
    public Observable<List<User>> getListOfUsers() {
        return apiInterface
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<List<String>> getListOfRepositories() {
        return null;
    }

    /*@SuppressWarnings("unchecked")
    <T> ObservableTransformer<T, T> applySchedulers() {
        observable -> ((Observable) observable).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }*/
}
