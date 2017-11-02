package com.homeaway.domain.api

import com.homeaway.domain.DataSource
import com.homeaway.domain.api.retrofit.SeatGeekService
import com.homeaway.domain.dto.Event
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Omar on 11/1/17.
 */

class ApiDataSource @Inject constructor(private val seatGeekService: SeatGeekService) : DataSource {

  override fun getEvents(searchTerm: String): Single<List<Event>> {
    return seatGeekService.retrieveEvents(searchTerm)
        .map { t -> t.events }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
  }
}
