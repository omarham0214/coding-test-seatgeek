package com.homeaway.seatgeek.base

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.homeaway.seatgeek.application.SeatGeekApplication
import com.homeaway.seatgeek.injection.MainComponent
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by Omar on 11/1/17.
 */

abstract class BaseActivity : AppCompatActivity() {

  protected abstract val layoutId: Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutId)
    setupToolbar()
    injectDependencies((application as SeatGeekApplication).mainComponent)
  }

  private fun setupToolbar() {
    if (home_toolbar != null) setSupportActionBar(home_toolbar)
    home_toolbar?.setTitleTextColor(Color.WHITE)
  }

  abstract fun injectDependencies(mainComponent: MainComponent?)
}
