package com.example.android.app.View;

import com.example.android.app.Others.User;

import java.util.List;

/**
 * Created by admin on 18.12.2017.
 */

public interface View {
    void showData(List<User> userList);
    void showError(String error);
}
