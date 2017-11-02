package com.homeaway.seatgeek

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.homeaway.domain.EventsProvider
import com.homeaway.seatgeek.injection.DaggerMainComponent
import com.homeaway.seatgeek.injection.DomainModule
import dagger.internal.DaggerCollections
import io.reactivex.functions.BiConsumer
import io.reactivex.functions.Consumer
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
        .subscribe(BiConsumer { t1, t2 -> Log.d("TAG_", t1.toString() + t2.toString()) })
  }
}
