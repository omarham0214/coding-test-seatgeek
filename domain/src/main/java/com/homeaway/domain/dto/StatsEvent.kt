package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StatsEvent(@SerializedName("event_count") var eventCount: Int) : Serializable
