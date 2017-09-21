package com.example.android.firebasetestlabexample;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Inject
    Clock mClock;

    @Singleton
    @Component(modules = MockClockModule.class)
    public interface TestComponent extends DemoComponent {

        void inject(MainActivityTest mainActivityTest);
    }

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<MainActivity>(
            MainActivity.class,
            true,
            false);

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        DemoApplication app = (DemoApplication) instrumentation.getTargetContext().getApplicationContext();
        TestComponent component = (TestComponent) app.getDemoComponent();
        component.inject(this);
    }

    @Test
    public void today() {
        Mockito.when(mClock.getNow()).thenReturn(new DateTime(2008, 9, 23, 0, 0, 0));

        mActivityTestRule.launchActivity(new Intent());

        onView(withId(R.id.date))
                .check(matches(withText("2008-09-23")));
    }

    @Test
    public void intent() {
        DateTime dateTime = new DateTime(2014, 10, 15, 0, 0 ,0);
        Intent intent = new Intent();
        intent.putExtra(MainActivity.KEY_MILLIS, dateTime.getMillis());

        mActivityTestRule.launchActivity(intent);

        onView(withId(R.id.date))
                .check(matches(withText("2014-10-15")));
    }
}
