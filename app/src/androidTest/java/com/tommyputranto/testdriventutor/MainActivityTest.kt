package com.tommyputranto.testdriventutor

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.*
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Tommy Dwi Putranto on 15/08/18.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Rule
    @JvmField
    val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun checkUserNameEditTextIsDisplayed(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.username)).check(matches(isDisplayed()))
    }

    @Test
    fun checkErrorMessageIsDisplayedForEmptyData(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.login)).check(matches(isDisplayed())).perform(click());
        onView(withText("Please check Username and Password")).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginSuccess(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.username)).check(matches(isDisplayed())).perform(typeText("tommy"), closeSoftKeyboard())
        onView(withId(R.id.password)).check(matches(isDisplayed())).perform(typeText("test"), closeSoftKeyboard())
        onView(withId(R.id.login)).check(matches(isDisplayed())).perform(click())
        onView(withText("Login Successfully")).check(matches(isDisplayed()))
    }
}