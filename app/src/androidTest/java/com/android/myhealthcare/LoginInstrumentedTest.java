package com.android.myhealthcare;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android.myhealthcare.controllers.LoginPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class LoginInstrumentedTest {

    @Rule
    public ActivityTestRule<LoginPage> testRule = new ActivityTestRule<>(LoginPage.class);

    @Test
    public void testLogin() {

        onView(withId(R.id.username)).perform(typeText("krranjik"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.password)).perform(typeText("kritik"));
        // close the keyboard
        closeSoftKeyboard();
        // click the update trip button
        onView(withId(R.id.btnlogin)).perform(click());
//        // verify that trip update toast is displayed
        onView(withText("Welcome,"))
                .inRoot(withDecorView(not(testRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }
}
