package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Event(@Json(name = "announce_date") var announceDate: String? = null,
            @Json(name = "taxonomies") var taxonomies: List<Taxonomy>? = null,
            @Json(name = "type") var type: String? = null,
            @Json(name = "datetime_local") var datetimeLocal: String? = null,
            @Json(name = "time_tbd") var timeTbd: Boolean = false,
            @Json(name = "is_open") var isOpen: Boolean = false,
            @Json(name = "score") var score: Double = 0.toDouble(),
            @Json(name = "popularity") var popularity: Double = 0.toDouble(),
            @Json(name = "visible_until_utc") var visibleUntilUtc: String? = null,
            @Json(name = "datetime_utc") var datetimeUtc: String? = null,
            @Json(name = "id") var id: Int = 0,
            @Json(name = "url") var url: String? = null,
            @Json(name = "venue") var venue: Venue? = null,
            @Json(name = "date_tbd") var dateTbd: Boolean = false,
            @Json(name = "links") var links: List<Any>? = null,
            @Json(name = "datetime_tbd") var datetimeTbd: Boolean = false,
            @Json(name = "statsEvent") var stats: Stats? = null,
            @Json(name = "title") var title: String? = null,
            @Json(name = "created_at") var createdAt: String? = null,
            @Json(name = "short_title") var shortTitle: String? = null,
            @Json(name = "performers") var performers: List<Performer>? = null)
