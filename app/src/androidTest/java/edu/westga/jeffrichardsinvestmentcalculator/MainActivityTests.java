package edu.westga.jeffrichardsinvestmentcalculator;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Tests for main activity
 *
 * Created by Jeff on 3/6/2016.
 */
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity> {
    public MainActivityTests() {
        super(MainActivity.class);
    }

    public void testActivityExists() {
        MainActivity activity = getActivity();
        assertNotNull(activity);
    }
}