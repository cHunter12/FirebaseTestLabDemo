package com.example.android.firebasetestlabexample;

public class MockDemoApplication extends DemoApplication {

    @Override
    protected DemoComponent createComponent() {
        return DaggerMainActivityTest_TestComponent.builder().build();
    }
}
