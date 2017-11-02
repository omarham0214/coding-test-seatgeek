package com.homeaway.domain.database

import com.homeaway.domain.DataSource
import com.homeaway.domain.dto.Event
import io.reactivex.Single

import javax.inject.Inject

/**
 * Created by Omar on 11/1/17.
 */
class DatabaseDataSource @Inject constructor() : DataSource {

  override fun getEvents(searchTerm: String): Single<List<Event>> {
    // TODO 11/1: Use database to avoid API lookup
    return Single.never()
  }
}