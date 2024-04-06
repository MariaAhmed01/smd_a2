package com.mariaahmed.i202451

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mariaahmed.i202451.loginscreen
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.assertion.ViewAssertions.matches

@RunWith(AndroidJUnit4::class)
class LoginScreenActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(loginscreen::class.java)

    @Test
    fun verifyForgotPasswordClick() {
        onView(withId(R.id.forgotpassword)).perform(click())
        // Your verification code for forgot password click
    }

    @Test
    fun verifySignUpClick() {
        onView(withId(R.id.signup_button)).perform(click())
        // Your verification code for sign up click
    }

    @Test
    fun testNavigateToForgotPasswordActivity() {
        onView(withId(R.id.forgotpassword)).perform(click())

        onView(withId(R.id.forgotpassscreen)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigateToSignUpActivity() {
        onView(withId(R.id.signup_button)).perform(click())

        onView(withId(R.id.signupscreen)).check(matches(isDisplayed()))
    }

}
