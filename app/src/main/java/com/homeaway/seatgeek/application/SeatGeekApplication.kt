package com.homeaway.seatgeek.application

import android.app.Application

import com.facebook.stetho.Stetho
import com.homeaway.seatgeek.injection.DaggerMainComponent
import com.homeaway.seatgeek.injection.DomainModule
import com.homeaway.seatgeek.injection.MainComponent
import com.squareup.leakcanary.LeakCanary

/**
 * Created by Omar on 11/1/17.
 */

class SeatGeekApplication : Application() {

  var mainComponent: MainComponent? = null
    private set

  override fun onCreate() {
    super.onCreate()

    if (LeakCanary.isInAnalyzerProcess(this)) {
      return
    }

    LeakCanary.install(this)
    Stetho.initializeWithDefaults(this)

    mainComponent = DaggerMainComponent.builder()
        .domainModule(DomainModule(this))
        .build()
  }
}
