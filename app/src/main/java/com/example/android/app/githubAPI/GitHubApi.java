package com.example.android.app.githubAPI;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 17.12.2017.
 */

public class GitHubApi {

    private static GitHubApiInterface gitApi;
    private Retrofit retrofit;

    public static GitHubApiInterface getApiInterface(String url) {

        //TODO: Авторизация гитхаб

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(GitHubApiInterface.class);
    }
}
