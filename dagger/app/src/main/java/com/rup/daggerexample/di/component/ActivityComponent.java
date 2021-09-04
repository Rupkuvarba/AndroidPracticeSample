package com.rup.daggerexample.di.component;

import com.rup.daggerexample.di.module.ActivityModule;
import com.rup.daggerexample.di.scope.ActivityScope;
import com.rup.daggerexample.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

//@Singleton in activity component we can't write singleton so define activity scope
@ActivityScope   // Hypothetical label scope created
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

    //you can give any name
}
