package com.example.android.firebasetestlabexample;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

public class DemoApplication extends Application {

    private final DemoComponent mDemoComponent = createComponent();

    public DemoComponent getDemoComponent() {
        return mDemoComponent;
    }

    protected DemoComponent createComponent() {
        return DaggerDemoComponent.builder().build();
    }

    @Singleton
    @Component(modules = ClockModule.class)
    public interface ApplicationComponent extends DemoComponent {
    }
}
