package com.mariaahmed.i202451

import android.content.Intent
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasAction
import androidx.test.espresso.intent.matcher.IntentMatchers.hasType
import androidx.test.espresso.intent.matcher.IntentMatchers.isInternal
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ProfileScreenTest {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(profilescreen::class.java)

    @Before
    fun setup() {
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun testOpenGalleryForBanner() {
        onView(withId(R.id.bg_pic)).perform(click())
        Intents.intended(
            allOf(
                hasAction(Intent.ACTION_PICK),
                hasType("image/*"),
                !isInternal()
            )
        )
    }

    @Test
    fun testOpenGalleryForProfilePicture() {
        onView(withId(R.id.profile_pic)).perform(click())
        Intents.intended(
            allOf(
                hasAction(Intent.ACTION_PICK),
                hasType("image/*"),
                !isInternal()
            )
        )
    }
}
