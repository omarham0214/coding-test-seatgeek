package com.homeaway.seatgeek

import android.view.View
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.presentation.home.HomeActivity
import kotlinx.android.synthetic.main.activity_home.*
import org.hamcrest.Matchers.any

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowToast

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.mockito.Mock
import java.util.*


/**
 * Created by Omar on 11/2/17.
 */

@RunWith(RobolectricTestRunner::class)
@Config(constants = BuildConfig::class)
class HomeActivityTest {

  private var homeActivity: HomeActivity? = null

  @Before
  @Throws(Exception::class)
  fun setUp() {
    homeActivity = Robolectric.setupActivity(HomeActivity::class.java)
  }

  @After
  @Throws(Exception::class)
  fun tearDown() {
    homeActivity = null
  }

  @Test
  @Throws(Exception::class)
  fun errorHappened_shouldSeeToastWithError() {
    val error = "Something went wrong!"

    homeActivity?.errorHappened(error)

    assertThat(ShadowToast.getTextOfLatestToast(), equalTo(error))
  }

  @Test
  @Throws(Exception::class)
  fun showProgressBar_progressBarShouldBeVisible() {
    homeActivity!!.showProgressBar(true, 0)

    assertThat(homeActivity?.home_progress?.visibility, equalTo(View.VISIBLE));
  }

  @Test
  @Throws(Exception::class)
  fun hideProgress_progressBarShouldBeInvisible() {
    homeActivity?.showProgressBar(true, 0)

    homeActivity?.hideProgressBar()

    assertThat(homeActivity?.home_progress?.visibility, equalTo(View.INVISIBLE))
  }

  @Test
  @Throws(Exception::class)
  fun showResults_mockData_listViewShouldNotContainData() {
    val results = listOf<Event>()

    homeActivity?.updateList(results)

    assertThat(homeActivity?.home_recycler?.adapter?.itemCount, equalTo(0))
  }
}
