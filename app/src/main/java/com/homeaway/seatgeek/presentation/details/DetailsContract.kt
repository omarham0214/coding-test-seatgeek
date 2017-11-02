package com.homeaway.seatgeek.presentation.details

import com.homeaway.domain.dto.Event

/**
 * Created by Omar on 11/2/17.
 */

interface DetailsContract {
  interface View {
    fun showFavorite(isFavorite: Boolean, favoriteChanged: Boolean)
  }

  interface Presenter {
    fun checkFavorite(event: Event?, favoriteChanged: Boolean)
    fun toggleFavorite(event: Event?)
    fun start(view: View)
    fun stop()
  }
}
