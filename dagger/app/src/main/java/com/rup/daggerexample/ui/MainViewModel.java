package com.rup.daggerexample.ui;

import com.rup.daggerexample.data.local.DatabaseService;
import com.rup.daggerexample.data.remote.NetworkService;

import javax.inject.Inject;

public class MainViewModel {

    private DatabaseService databaseService;
    private NetworkService networkService;

    @Inject
    public MainViewModel(DatabaseService databaseService, NetworkService networkService) {
        this.databaseService = databaseService;
        this.networkService = networkService;
    }

    public String getSomeData() {
        return databaseService.getDummyData() + " : " + networkService.getDummyData();
    }
}
