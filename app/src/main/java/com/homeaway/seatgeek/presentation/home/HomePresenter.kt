package com.homeaway.seatgeek.presentation.home

import com.homeaway.domain.EventsProvider
import com.homeaway.domain.dto.Event
import io.reactivex.Observable
import io.reactivex.Observable.create
import io.reactivex.Observable.just
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import java.util.*
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

  override fun loadEvents(searchTerm: String) {
//    eventsProvider.getEvents(searchTerm)
//        .doOnError({ view?.errorHappened(it.localizedMessage) })
//        .doOnSuccess { view?.hideProgressBar() }
//        .subscribe { results -> view?.updateList(results) }

    println("$searchTerm ${Date()}")
  }
}
