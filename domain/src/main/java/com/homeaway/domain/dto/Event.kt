package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName

data class Event(@SerializedName("announce_date") var announceDate: String,
                 @SerializedName("taxonomies") var taxonomies: List<Taxonomy>,
                 @SerializedName("type") var type: String,
                 @SerializedName("datetime_local") var datetimeLocal: String,
                 @SerializedName("time_tbd") var timeTbd: Boolean,
                 @SerializedName("is_open") var isOpen: Boolean,
                 @SerializedName("score") var score: Double,
                 @SerializedName("popularity") var popularity: Double,
                 @SerializedName("visible_until_utc") var visibleUntilUtc: String,
                 @SerializedName("datetime_utc") var datetimeUtc: String,
                 @SerializedName("id") var id: Int,
                 @SerializedName("url") var url: String,
                 @SerializedName("venue") var venue: Venue,
                 @SerializedName("date_tbd") var dateTbd: Boolean,
                 @SerializedName("links") var links: List<Any>,
                 @SerializedName("datetime_tbd") var datetimeTbd: Boolean,
                 @SerializedName("statsEvent") var stats: Stats,
                 @SerializedName("title") var title: String,
                 @SerializedName("created_at") var createdAt: String,
                 @SerializedName("short_title") var shortTitle: String,
                 @SerializedName("performers") var performers: List<Performer>,
                 var isFavorite: Boolean)
