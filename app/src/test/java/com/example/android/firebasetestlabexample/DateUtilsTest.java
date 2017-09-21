package com.example.android.firebasetestlabexample;

import static com.google.common.truth.Truth.assertThat;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DateUtilsTest {

    @Test
    public void format() {
        assertThat(DateUtils.format(new DateTime(2008, 9, 23, 0, 0, 0))).isEqualTo("2008-09-23");
    }
}