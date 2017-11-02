package com.homeaway.seatgeek.presentation.details

import com.homeaway.domain.EventsProvider
import com.homeaway.domain.dto.Event
import com.homeaway.seatgeek.presentation.home.HomeContract
import javax.inject.Inject

/**
 * Created by Omar on 11/2/17.
 */

class DetailsPresenter @Inject constructor(private val eventsProvider: EventsProvider) : DetailsContract.Presenter {

  var view: DetailsContract.View? = null

  override fun checkFavorite(event: Event) {
    view?.showFavorite(eventsProvider.isFavorite(event))
  }

  override fun toggleFavorite(event: Event) {
    eventsProvider.toggleFavoriteEvent(event)
    checkFavorite(event)
  }

  override fun start(view: DetailsContract.View) {
    this.view = view;
  }

  override fun stop() {
    this.view = null
  }
}
