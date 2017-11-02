package com.homeaway.seatgeek.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.homeaway.seatgeek.application.SeatGeekApplication
import com.homeaway.seatgeek.injection.MainComponent

/**
 * Created by Omar on 11/1/17.
 */

abstract class BaseActivity : AppCompatActivity() {

  protected abstract val layoutId: Int

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layoutId)
    injectDependencies((application as SeatGeekApplication).mainComponent)
  }

  abstract fun injectDependencies(mainComponent: MainComponent?)
}
