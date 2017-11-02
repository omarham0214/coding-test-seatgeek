package com.homeaway.domain

import com.homeaway.domain.dto.Event
import io.reactivex.Single

/**
 * Created by Omar on 11/1/17.
 */

interface DataSource {
  fun getEvents(searchTerm: String): Single<List<Event>>
}