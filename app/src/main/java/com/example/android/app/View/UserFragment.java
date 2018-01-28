package com.example.android.app.View;

import com.example.android.app.Others.User;
import com.example.android.app.Presenter.Presenter;
import com.example.android.app.Presenter.PresenterUser;
import com.example.android.app.Presenter.SingleUserPresenter;
import com.example.android.app.Presenter.UsersListPresenter;
import com.example.android.githubUsers.R;

import java.util.ArrayList;
import java.util.List;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.*;
import android.view.View;
import android.widget.ProgressBar;


/**
 * Created by admin on 09.01.2018.
 */

public class UserFragment extends Fragment implements ViewUser, ViewSingleUser {

    UserAdapter adapter;
    Presenter presenter;
    PresenterUser presenterUser;

    public static UserFragment newInstance() {

        Bundle args = new Bundle();
        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<User> list = new ArrayList<User>();
        adapter = new UserAdapter(list, getActivity());

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        presenter = new UsersListPresenter(this);
        presenter.getData();
        presenterUser = new SingleUserPresenter(this);
    }

    @Override
    public void showData(List<User> userList) {
        adapter.addAll(userList);
        for (User user : userList) {
            //ProgressBar progressBar = getActivity().findViewById(R.id.card_progressbar);
            //progressBar.setVisibility(View.VISIBLE);
            presenterUser.getData(user.getLogin(), userList.indexOf(user));
        }
    }

    @Override
    public void showError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(error.toString() + "\nTry later!")
                .setTitle("Error");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void showData(User user, int position) {
        adapter.addSingle(user, position);
    }
}
