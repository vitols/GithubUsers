package com.example.android.app.Model;

import com.example.android.app.Others.Repo;
import com.example.android.app.Others.User;
import com.example.android.app.githubAPI.GitHubApi;
import com.example.android.app.githubAPI.GitHubApiInterface;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.android.schedulers.AndroidSchedulers;
import retrofit2.Response;

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
    public Observable<List<Repo>> getListOfRepositories(String userName) {
        return apiInterface
                .getReposOfUser(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    @Override
    public Observable<User> getSingleUser(String userName) {
        return apiInterface
                .getSingleUser(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
