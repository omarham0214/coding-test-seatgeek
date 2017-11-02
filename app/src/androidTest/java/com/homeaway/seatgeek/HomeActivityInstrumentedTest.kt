package com.homeaway.seatgeek

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.homeaway.seatgeek.presentation.home.HomeActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Omar on 11/2/17.
 */

@RunWith(AndroidJUnit4::class)
class HomeActivityInstrumentedTest {

  @Rule
  @JvmField
  val activity = ActivityTestRule<HomeActivity>(HomeActivity::class.java)

  @Test
  fun searchQuery_shouldLoadDataRecycler() {

    getViewFromId(R.id.home_search)
        .perform(click())

    getViewFromId(R.id.searchTextView)
        .perform(typeText("Michigan Wolverines"))

    getViewFromId(R.id.home_progress)
        .check(matches(isDisplayed()))

    getViewFromId(R.id.home_recycler)
        .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

    getViewFromId(R.id.details_date)
        .check(matches(not(withText(""))))
  }

  private fun getViewFromId(id: Int) = onView(withId(id))
}
