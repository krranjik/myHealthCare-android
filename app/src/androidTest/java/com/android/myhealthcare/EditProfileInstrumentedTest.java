package com.android.myhealthcare;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android.myhealthcare.controllers.Profile;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class EditProfileInstrumentedTest {

    @Rule
    public ActivityTestRule<Profile> testRule = new ActivityTestRule<>(Profile.class);

    @Before
    public void setupHomeFragment() {
        testRule.getActivity().getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void testEditProfile() {
        onView(withId(R.id.editprofile)).perform(click());

        onView(withId(R.id.name)).perform(replaceText(""));
        onView(withId(R.id.address)).perform(replaceText(""));
        onView(withId(R.id.dob)).perform(replaceText(""));
        onView(withId(R.id.bloodgroup)).perform(replaceText(""));
        onView(withId(R.id.weight)).perform(replaceText(""));
        onView(withId(R.id.height)).perform(replaceText(""));
        onView(withId(R.id.phone)).perform(replaceText(""));

        onView(withId(R.id.name)).perform(typeText("kritik"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.address)).perform(typeText("add"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.dob)).perform(typeText("aug"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.bloodgroup)).perform(typeText("a-"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.weight)).perform(typeText("70"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.height)).perform(typeText("5.5"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.phone)).perform(typeText("5678789"));
        // close the keyboard
        closeSoftKeyboard();

        // click the save button
        onView(withId(R.id.save)).perform(click());

    }
}
