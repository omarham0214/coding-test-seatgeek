package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Venue(@Json(name = "slug") var slug: String? = null,
                 @Json(name = "url") var url: String? = null,
                 @Json(name = "score") var score: Double = 0.toDouble(),
                 @Json(name = "location") var location: Location? = null,
                 @Json(name = "postal_code") var postalCode: String? = null,
                 @Json(name = "name") var name: String? = null,
                 @Json(name = "num_upcoming_events") var numUpcomingEvents: Int = 0,
                 @Json(name = "address") var address: String? = null,
                 @Json(name = "name_v2") var nameV2: String? = null,
                 @Json(name = "country") var country: String? = null,
                 @Json(name = "links") var links: List<Any>? = null,
                 @Json(name = "timezone") var timezone: String? = null,
                 @Json(name = "extended_address") var extendedAddress: String? = null,
                 @Json(name = "popularity") var popularity: Int = 0,
                 @Json(name = "city") var city: String? = null,
                 @Json(name = "has_upcoming_events") var hasUpcomingEvents: Boolean = false,
                 @Json(name = "display_location") var displayLocation: String? = null,
                 @Json(name = "state") var state: String? = null,
                 @Json(name = "id") var id: Int = 0)
