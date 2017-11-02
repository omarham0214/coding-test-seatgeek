package com.homeaway.seatgeek.injection

import com.homeaway.seatgeek.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Omar on 11/1/17.
 */
@Singleton
@Component(modules = arrayOf(DomainModule::class))
interface MainComponent {
  fun inject(mainActivity: MainActivity)
}