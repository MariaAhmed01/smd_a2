package com.mariaahmed.i202451

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mariaahmed.i202451.Signup
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

@RunWith(AndroidJUnit4::class)
class SignupActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Signup::class.java)

    @Test
    fun testSignupButtonClick() {
        onView(withId(R.id.signupbutton)).perform(click())
        // Your verification code for sign-up button click
    }

    @Test
    fun testNavigateToLoginActivity() {
        onView(withId(R.id.login_button)).perform(click())

        // Check if the login activity is displayed
        onView(withId(R.id.loginscreen)).check(matches(isDisplayed()))
    }

    @Test
    fun testSignupTitleDisplayed() {
        // Check if the sign-up title is displayed
        onView(withId(R.id.signuptitle)).check(matches(isDisplayed()))
    }

    @Test
    fun testSignupFieldsDisplayed() {
        // Check if the name, email, contact number, country, city, and password fields are displayed
        onView(withId(R.id.name)).check(matches(isDisplayed()))
        onView(withId(R.id.email)).check(matches(isDisplayed()))
        onView(withId(R.id.contactnumber)).check(matches(isDisplayed()))
        onView(withId(R.id.my_spinner_country)).check(matches(isDisplayed()))
        onView(withId(R.id.my_spinner_city)).check(matches(isDisplayed()))
        onView(withId(R.id.password)).check(matches(isDisplayed()))
    }
}
