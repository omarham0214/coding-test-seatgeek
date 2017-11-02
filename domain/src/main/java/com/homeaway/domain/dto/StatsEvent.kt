package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName

data class StatsEvent(@SerializedName("event_count") var eventCount: Int)
