package com.rup.daggerexample;

import android.app.Application;
import android.util.Log;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.di.component.ApplicationComponent;
import com.rup.daggerexample.di.component.DaggerApplicationComponent;
import com.rup.daggerexample.di.module.ApplicationModule;

import javax.inject.Inject;

//dependency consumer
public class MyApplication extends Application {

    @Inject
    public NetworkService networkService;

    @Inject
    public DatabaseService databaseService;

    public ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject( this);

        Log.d("DEBUG",  "service: networkService "+networkService);
    }
}