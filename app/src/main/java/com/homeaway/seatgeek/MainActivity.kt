package com.homeaway.seatgeek

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.homeaway.domain.EventsProvider
import com.homeaway.seatgeek.injection.DaggerMainComponent
import com.homeaway.seatgeek.injection.DomainModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

  @Inject
  lateinit var eventsProvider: EventsProvider

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    DaggerMainComponent.builder()
        .domainModule(DomainModule(this))
        .build()
        .inject(this)

    eventsProvider.getEvents("Texas+Rangers")
        .subscribe({ Log.d("TAG_", it.toString()) }, { it.printStackTrace() })
  }
}
