package com.homeaway.domain

import com.homeaway.domain.dto.SeatGeek
import java.util.function.Consumer

/**
 * Created by Omar on 11/1/17.
 */

interface DataSource {
  fun getEvents(searchTerm: String): Consumer<SeatGeek>
}