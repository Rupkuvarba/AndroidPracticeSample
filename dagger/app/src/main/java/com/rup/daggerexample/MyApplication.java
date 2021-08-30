package com.rup.daggerexample;

import android.app.Application;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.di.DependencyComponent;

public class MyApplication extends Application {

    public NetworkService networkService;
    public DatabaseService databaseService;

    @Override
    public void onCreate() {
        super.onCreate();
        DependencyComponent.inject(this);
    }
}