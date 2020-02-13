package com.android.myhealthcare;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import com.android.myhealthcare.controllers.RegistrationPage;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class RegisterInstrumentedTest {
    @Rule
    public ActivityTestRule<RegistrationPage> testRule = new ActivityTestRule<>(RegistrationPage.class);

    @Test
    public void testRegister() {

        onView(withId(R.id.fullname)).perform(typeText("testing"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.username)).perform(typeText("test"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.email)).perform(typeText("test@test.com"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.password)).perform(typeText("test"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.repassword)).perform(typeText("test"));
        // close the keyboard
        closeSoftKeyboard();
        onView(withId(R.id.rbmale)).perform(click());
////        // close the keyboard
//        closeSoftKeyboard();
        // click the register button
        onView(withId(R.id.signup)).perform(scrollTo()).perform(click());
//        // verify toast is displayed
        onView(withText("User has been registered"))
                .inRoot(withDecorView(not(testRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));
    }
}
