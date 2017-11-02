package com.homeaway.seatgeek.presentation.details.injection

import com.homeaway.seatgeek.injection.MainComponent
import com.homeaway.seatgeek.injection.PerView
import com.homeaway.seatgeek.presentation.details.DetailsActivity
import com.squareup.haha.perflib.Main

import dagger.Component

/**
 * Created by Omar on 11/2/17.
 */

@PerView
@Component(dependencies = arrayOf(MainComponent::class))
interface DetailsComponent {
  fun inject(detailsActivity: DetailsActivity)
}
