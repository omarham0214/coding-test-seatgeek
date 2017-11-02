package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Location(@Json(name = "lat") var lat: Double,
                    @Json(name = "lon") var lon: Double)
