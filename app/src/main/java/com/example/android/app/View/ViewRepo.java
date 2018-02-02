package com.example.android.app.View;

import com.example.android.app.Model.Repo;

import java.util.List;

/**
 * Created by admin on 21.01.2018.
 */

public interface ViewRepo extends View {
    void showData(List<Repo> userList);
}
