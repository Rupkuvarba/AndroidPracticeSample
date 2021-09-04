package com.rup.daggerexample.di.module;

import android.app.Activity;
import android.content.Context;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.ui.MainViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    Context provideContext(){
        return activity;
    }
  /*  @Provides
    MainViewModel provideMainViewModel(DatabaseService databaseService, NetworkService networkService){
        return new MainViewModel(databaseService, networkService);
    }*/
}
