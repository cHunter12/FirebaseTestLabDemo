package com.example.android.firebasetestlabexample;

import org.joda.time.DateTime;

import javax.inject.Singleton;

@Singleton
public class Clock {

    public DateTime getNow() {
        return new DateTime();
    }
}
