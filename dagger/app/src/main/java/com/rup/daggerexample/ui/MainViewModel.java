package com.rup.daggerexample.ui;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;

public class MainViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;

    public MainViewModel(DatabaseService databaseService, NetworkService networkService) {
        this.databaseService = databaseService;
        this.networkService = networkService;
    }

    public String getSomeData() {
        return databaseService.getDummyData() + " : " + networkService.getDummyData();
    }
}
