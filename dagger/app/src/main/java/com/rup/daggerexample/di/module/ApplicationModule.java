package com.rup.daggerexample.di.module;

import android.app.Application;
import android.content.Context;

import com.rup.daggerexample.MyApplication;
import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.di.qualifier.DatabaseInfo;
import com.rup.daggerexample.di.qualifier.NetworkInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module //Provide recipe
public class ApplicationModule {

    private MyApplication application;

    public ApplicationModule(MyApplication application) {
        this.application = application;
    }

    @Provides
    Context provideContext(){
        return application;
    }

    @DatabaseInfo
    @Provides
    String provideDatabaseName(){
        return "dbAbc";
    }

    @Provides
    int provideDatabaseVersion(){
        return 1;
    }

    @NetworkInfo
    @Provides
    String provideAPIKey(){
        return "apiKey";
    }

    //Dagger understand return type not understand method name so apikey and db name gives error


}
