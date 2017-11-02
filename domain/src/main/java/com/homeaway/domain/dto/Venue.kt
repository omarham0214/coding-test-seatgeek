package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Venue(@SerializedName("slug") var slug: String,
                 @SerializedName("url") var url: String,
                 @SerializedName("score") var score: Double,
                 @SerializedName("location") var location: Location,
                 @SerializedName("postal_code") var postalCode: String,
                 @SerializedName("name") var name: String,
                 @SerializedName("num_upcoming_events") var numUpcomingEvents: Int,
                 @SerializedName("address") var address: String,
                 @SerializedName("name_v2") var nameV2: String,
                 @SerializedName("country") var country: String,
                 @SerializedName("links") var links: List<Any>,
                 @SerializedName("timezone") var timezone: String,
                 @SerializedName("extended_address") var extendedAddress: String,
                 @SerializedName("popularity") var popularity: Int,
                 @SerializedName("city") var city: String,
                 @SerializedName("has_upcoming_events") var hasUpcomingEvents: Boolean,
                 @SerializedName("display_location") var displayLocation: String,
                 @SerializedName("state") var state: String,
                 @SerializedName("id") var id: Int = 0) : Serializable
