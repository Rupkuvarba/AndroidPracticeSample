package com.rup.daggerexample.di.component;

import com.rup.daggerexample.MyApplication;
import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);   //you can give any name of method

    NetworkService getNetworkService();

    DatabaseService getDatabaseService();
}
