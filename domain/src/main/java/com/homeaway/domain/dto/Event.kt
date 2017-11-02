package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Event(@Json(name = "announce_date") var announceDate: String,
            @Json(name = "taxonomies") var taxonomies: List<Taxonomy>,
            @Json(name = "type") var type: String,
            @Json(name = "datetime_local") var datetimeLocal: String,
            @Json(name = "time_tbd") var timeTbd: Boolean,
            @Json(name = "is_open") var isOpen: Boolean,
            @Json(name = "score") var score: Double,
            @Json(name = "popularity") var popularity: Double,
            @Json(name = "visible_until_utc") var visibleUntilUtc: String,
            @Json(name = "datetime_utc") var datetimeUtc: String,
            @Json(name = "id") var id: Int,
            @Json(name = "url") var url: String,
            @Json(name = "venue") var venue: Venue,
            @Json(name = "date_tbd") var dateTbd: Boolean,
            @Json(name = "links") var links: List<Any>,
            @Json(name = "datetime_tbd") var datetimeTbd: Boolean,
            @Json(name = "statsEvent") var stats: Stats,
            @Json(name = "title") var title: String,
            @Json(name = "created_at") var createdAt: String,
            @Json(name = "short_title") var shortTitle: String,
            @Json(name = "performers") var performers: List<Performer>)
