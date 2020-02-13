package com.android.myhealthcare;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android.myhealthcare.controllers.Doctor;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class BookAppointmentInstrumentedTest {

    @Rule
    public ActivityTestRule<Doctor> testRule = new ActivityTestRule<>(Doctor.class);

    @Before
    public void setupHomeFragment() {
        testRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void testBookAppointment() {
        // verify that the doctor recycler view is displayed
        onView(withId(R.id.rv_doctors)).check(matches(isDisplayed()));
        // click the first item in the recycler view
        onView(withId(R.id.rv_doctors))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withId(R.id.bookappointment)).perform(click());

        onView(withId(R.id.btnbookapp)).perform(click());

    }
}
