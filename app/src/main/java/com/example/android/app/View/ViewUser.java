package com.example.android.app.View;

import com.example.android.app.Model.User;

import java.util.List;

/**
 * Created by admin on 21.01.2018.
 */

public interface ViewUser extends View{
    void showData(List<User> userList);
}
