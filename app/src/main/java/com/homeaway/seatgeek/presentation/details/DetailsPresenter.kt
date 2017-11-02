package com.homeaway.seatgeek.presentation.details

import com.homeaway.domain.EventsProvider
import com.homeaway.domain.dto.Event
import javax.inject.Inject

/**
 * Created by Omar on 11/2/17.
 */

class DetailsPresenter @Inject constructor(private val eventsProvider: EventsProvider) : DetailsContract.Presenter {

  var view: DetailsContract.View? = null

  override fun checkFavorite(event: Event?, favoriteChanged: Boolean) {
    val isFavorite = eventsProvider.isFavorite(event)
    event?.isFavorite = isFavorite
    view?.showFavorite(isFavorite, favoriteChanged)
  }

  override fun toggleFavorite(event: Event?) {
    eventsProvider.toggleFavoriteEvent(event)
    checkFavorite(event, true)
  }

  override fun start(view: DetailsContract.View) {
    this.view = view;
  }

  override fun stop() {
    this.view = null
  }
}
