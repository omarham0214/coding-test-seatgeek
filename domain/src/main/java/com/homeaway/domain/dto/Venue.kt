package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Venue(@Json(name = "slug") var slug: String,
                 @Json(name = "url") var url: String,
                 @Json(name = "score") var score: Double,
                 @Json(name = "location") var location: Location,
                 @Json(name = "postal_code") var postalCode: String,
                 @Json(name = "name") var name: String,
                 @Json(name = "num_upcoming_events") var numUpcomingEvents: Int,
                 @Json(name = "address") var address: String,
                 @Json(name = "name_v2") var nameV2: String,
                 @Json(name = "country") var country: String,
                 @Json(name = "links") var links: List<Any>,
                 @Json(name = "timezone") var timezone: String,
                 @Json(name = "extended_address") var extendedAddress: String,
                 @Json(name = "popularity") var popularity: Int,
                 @Json(name = "city") var city: String,
                 @Json(name = "has_upcoming_events") var hasUpcomingEvents: Boolean,
                 @Json(name = "display_location") var displayLocation: String,
                 @Json(name = "state") var state: String,
                 @Json(name = "id") var id: Int = 0)
