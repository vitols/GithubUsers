package com.example.android.app;

import com.jakewharton.threetenabp.AndroidThreeTen;

/**
 * Created by admin on 21.01.2018.
 */

public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndroidThreeTen.init(this);
    }
}
