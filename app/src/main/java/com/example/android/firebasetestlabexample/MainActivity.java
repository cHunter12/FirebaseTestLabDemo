package com.example.android.firebasetestlabexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import org.joda.time.DateTime;

import javax.inject.Inject;

public class MainActivity extends Activity {

    @Inject
    Clock mClock;
    public static final String KEY_MILLIS = "millis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((DemoApplication) getApplication()).getDemoComponent().inject(this);

        TextView todayView = findViewById(R.id.date);

        long millis = getIntent().getLongExtra(KEY_MILLIS, -1);
        DateTime dateTime = (millis > 0) ? new DateTime(millis) : mClock.getNow();
        todayView.setText(DateUtils.format(dateTime));
    }
}
