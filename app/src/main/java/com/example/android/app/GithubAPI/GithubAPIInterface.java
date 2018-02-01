package com.example.android.app.GithubAPI;

import com.example.android.app.Others.Repo;
import com.example.android.app.Others.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.Observable;

/**
 * Created by admin on 17.12.2017.
 */

public interface GithubAPIInterface {
    @GET("/users")
    Observable<List<User>> getUsers();

    @GET("/users/{user}/repos")
    Observable<List<Repo>> getReposOfUser(@Path("user") String user);

    @GET("/users/{user}")
    Observable<User> getSingleUser(@Path("user") String user);

}
