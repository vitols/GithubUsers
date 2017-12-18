package com.example.android.app.View;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.android.app.Presenter.Presenter;
import com.example.android.app.Presenter.UsersListPresenter;
import com.example.android.githubUsers.R;
import com.example.android.app.Others.User;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View {

    TextView textView;
    android.view.View view;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        view = findViewById(R.layout.activity_main);
        Presenter presenter = new UsersListPresenter(this);
        presenter.getData();
    }

    @Override
    public void showData(List<User> userList) {
        Log.d("list", userList.toString());
    }

    @Override
    public void showError(String error) {
        textView.setText("Error");
    }
}
