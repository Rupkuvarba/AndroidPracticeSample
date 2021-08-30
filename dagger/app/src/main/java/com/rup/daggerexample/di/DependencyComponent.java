package com.rup.daggerexample.di;

import android.util.Log;

import com.rup.daggerexample.MyApplication;
import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;
import com.rup.daggerexample.ui.MainActivity;
import com.rup.daggerexample.ui.MainViewModel;

public class DependencyComponent {

    public static void inject(MyApplication application) {
        application.networkService = new NetworkService(application, "SOME_API_KEY");
        application.databaseService = new DatabaseService(application, "dummy_db", 1);
    }

    public static void inject(MainActivity activity) {
        Log.d("DependencyComponent", " DependencyComponent inject: activity: "+activity);

        if(activity.getApplication() instanceof  MyApplication){
            MyApplication app = (MyApplication) activity.getApplication();
            activity.viewModel = new MainViewModel(app.databaseService, app.networkService);
        }

    }

}
