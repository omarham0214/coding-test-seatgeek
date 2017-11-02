package com.homeaway.seatgeek.presentation.home.injection

import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.injection.PerView
import com.homeaway.seatgeek.presentation.home.HomeActivity
import dagger.Component

/**
 * Created by Omar on 11/1/17.
 */

@PerView
@Component(dependencies = arrayOf(MainComponent::class))
interface HomeComponent {
  fun inject(homeActivity: HomeActivity)
}
