package com.example.android.firebasetestlabexample;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ClockModule {

    @Provides
    @Singleton
    Clock provideClock() {
        return new Clock();
    }
}
