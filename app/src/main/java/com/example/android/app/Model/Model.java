package com.example.android.app.Model;

import com.example.android.app.Others.User;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by admin on 17.12.2017.
 */

public interface Model {
    Observable<List<User>> getListOfUsers();
    Observable<List<String>> getListOfRepositories();
}
