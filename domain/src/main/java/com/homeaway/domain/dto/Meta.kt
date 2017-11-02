package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Meta(@Json(name = "per_page") var perPage: Int,
                @Json(name = "page") var page: Int,
                @Json(name = "geolocation") var geolocation: Any,
                @Json(name = "took") var took: Int,
                @Json(name = "total") var total: Int)
