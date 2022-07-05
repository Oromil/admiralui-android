package com.admiral.demo.clicker

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.ext.junit.rules.activityScenarioRule
import com.admiral.demo.R
import com.admiral.demo.app.AppActivity
import com.admiral.demo.ext.BetterScrollTo
import com.admiral.demo.ext.withIndex
import com.admiral.demo.filters.ClickerTest
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test


class BadgesAutoTest : ClickerTest {
    private val intent = Intent(
        ApplicationProvider.getApplicationContext(),
        AppActivity::class.java
    ).putExtra(AppActivity.KEY_IS_TEST, true)

    @get:Rule
    var activityScenarioRule = activityScenarioRule<AppActivity>(intent)

    @Test
    fun openBadgesScreen() {
        onView(withId(R.id.badgesButton)).perform(BetterScrollTo())
        onView(withId(R.id.badgesButton)).perform(click())
        onView(withId(R.id.btnNormalBadges)).perform(click())

        onView(withIndex(withId(R.id.incrementImageView), 0)).perform(click())
        onView(allOf(withId(R.id.incrementImageView), withParent(withId(R.id.inputNumber)))).perform(click())

        onView(withIndex(withId(R.id.incrementImageView), 1)).perform(click())
        onView(allOf(withId(R.id.incrementImageView), withParent(withId(R.id.inputNumber1)))).perform(click())
    }
}