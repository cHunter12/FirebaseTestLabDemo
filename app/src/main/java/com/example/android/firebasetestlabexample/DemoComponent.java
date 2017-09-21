package com.example.android.firebasetestlabexample;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ClockModule.class)
public interface DemoComponent {

    void inject(MainActivity mainActivity);
}
