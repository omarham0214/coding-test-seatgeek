package com.homeaway.domain

import com.homeaway.domain.api.ApiDataSource
import com.homeaway.domain.database.DatabaseDataSource
import com.homeaway.domain.dto.Event
import com.homeaway.domain.preferences.PreferencesDataSource
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by Omar on 11/1/17.
 */
class EventsProvider @Inject constructor(private val apiDataSource: ApiDataSource,
                                         private val databaseDataSource: DatabaseDataSource,
                                         private val preferencesDataSource: PreferencesDataSource) : DataSource {

  override fun getEvents(searchTerm: String): Single<List<Event>> {
    // TODO 11/1: Concatenate observables from database and remote sources when databaseDataSource is implemented
    return apiDataSource.getEvents(searchTerm)
  }

  fun toggleFavoriteEvent(event: Event): Boolean {
    preferencesDataSource.toggleFavorite(event)
    return isFavorite(event)
  }

  fun isFavorite(event: Event) = preferencesDataSource.isFavorite(event)
}