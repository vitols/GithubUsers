package com.example.android.app.View;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.app.Model.Repo;
import com.example.android.app.Presenter.Presenter;
import com.example.android.app.Presenter.ReposListPresenter;
import com.example.android.githubUsers.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 21.01.2018.
 */

public class RepoFragment extends Fragment implements ViewRepo {

    private static final String BUNDLE_KEY = "userName";
    RepoAdapter adapter;
    Presenter presenter;

    public static RepoFragment newInstance(String userName) {
        Bundle args = new Bundle();
        args.putString(BUNDLE_KEY, userName);
        RepoFragment fragment = new RepoFragment();
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
        List<Repo> repos = new ArrayList<Repo>();
        adapter = new RepoAdapter(repos);

        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Bundle b = getArguments();
        String userName = b.getString(BUNDLE_KEY);
        presenter = new ReposListPresenter(this, userName);
        presenter.getData();
    }

    @Override
    public void showData(List<Repo> repoList) {
        adapter.addAll(repoList);
    }

    @Override
    public void showError(String error) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(error.toString() + R.string.alert_dialog_message)
                .setTitle(R.string.alert_dialog_title)
                .setPositiveButton(R.string.alert_dialog_button, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
