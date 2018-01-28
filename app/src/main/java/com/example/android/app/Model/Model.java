package com.example.android.app.Model;

import com.example.android.app.Others.Repo;
import com.example.android.app.Others.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;

/**
 * Created by admin on 17.12.2017.
 */

public interface Model {
    Observable<List<User>> getListOfUsers();
    Observable<List<Repo>> getListOfRepositories(String userName);
    Observable<User> getSingleUser(String userName);
}
