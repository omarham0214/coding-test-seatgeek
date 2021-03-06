package com.homeaway.seatgeek.presentation.home

import com.homeaway.domain.EventsProvider
import com.homeaway.domain.dto.Event
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by Omar on 11/1/17.
 */

class HomePresenter @Inject constructor(private val eventsProvider: EventsProvider) : HomeContract.Presenter {

  private var view: HomeContract.View? = null
  private var compositeDisposable: CompositeDisposable? = null

  override fun start(view: HomeContract.View) {
    this.view = view;
    compositeDisposable = CompositeDisposable()
  }

  override fun stop() {
    this.view = null
    compositeDisposable?.dispose()
  }

  override fun loadEvents(searchTerm: String?) {
    view?.showProgressBar(true, 0)
    eventsProvider.getEvents(searchTerm)
        .map { checkFavorites(it) }
        .doOnError({ streamEnded(false, it.localizedMessage) })
        .doOnSuccess { streamEnded(true, null) }
        .subscribe { results -> view?.updateList(results) }
  }

  private fun checkFavorites(events: List<Event>): List<Event> {
    events.forEach { it.isFavorite = eventsProvider.isFavorite(it) }
    return events
  }

  private fun streamEnded(endedCorrectly: Boolean, message: String?) {
    if (!endedCorrectly) {
      view?.errorHappened(message ?: "Something went wrong!")
    }
    view?.hideProgressBar()
  }
}
