package com.homeaway.seatgeek.presentation.details

import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.presentation.home.HomeContract

/**
 * Created by Omar on 11/2/17.
 */

interface DetailsContract {
  interface View {
    fun showFavorite(boolean: Boolean)
  }

  interface Presenter {
    fun checkFavorite(event: Event)
    fun toggleFavorite(event: Event)
    fun start(view: View)
    fun stop()
  }
}
