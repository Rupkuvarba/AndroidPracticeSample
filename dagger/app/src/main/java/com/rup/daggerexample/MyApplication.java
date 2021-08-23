package com.rup.daggerexample;

import android.app.Application;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;

public class MyApplication extends Application {

    public NetworkService networkService;
    public DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        networkService = new NetworkService(this, "SOME_API_KEY");
        databaseService = new DatabaseService(this, "dummy_db", 1);
    }
}