package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Location(@Json(name = "lat") var lat: Double = 0.toDouble(),
                    @Json(name = "lon") var lon: Double = 0.toDouble())
