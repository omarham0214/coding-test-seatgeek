package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class StatsEvent(@Json(name = "event_count") var eventCount: Int)
