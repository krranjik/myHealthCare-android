package com.android.myhealthcare;

import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android.myhealthcare.controllers.Doctor;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class DoctorInstrumentedTest {

    @Rule
    public ActivityTestRule<Doctor> testRule = new ActivityTestRule<>(Doctor.class);

    @Test
    public void testDoctor() {
        // verify that the doctor recycler view is displayed
        onView(withId(R.id.rv_doctors)).check(matches(isDisplayed()));
        // click the first item in the recycler view
        onView(withId(R.id.rv_doctors))
                .perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));

        onView(withText("Location"))
                .inRoot(withDecorView(not(testRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

    }
}
