package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Meta(@Json(name = "per_page") var perPage: Int = 0,
                @Json(name = "page") var page: Int = 0,
                @Json(name = "geolocation") var geolocation: Any? = null,
                @Json(name = "took") var took: Int = 0,
                @Json(name = "total") var total: Int = 0)
