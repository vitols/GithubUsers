package com.example.android.app.githubAPI;

import com.example.android.app.Others.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.Observable;

/**
 * Created by admin on 17.12.2017.
 */

public interface GitHubApiInterface {
    @GET("/users")
    Observable<List<User>> getUsers();

    @GET("/users/{user}/repo")
    Observable<List<String>> getReposOfUser(@Path("user") String user);

}
