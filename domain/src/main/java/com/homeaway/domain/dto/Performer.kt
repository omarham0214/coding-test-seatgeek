package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Performer(@Json(name = "image") var image: String? = null,
                     @Json(name = "short_name") var shortName: String? = null,
                     @Json(name = "taxonomies") var taxonomies: List<Taxonomy>? = null,
                     @Json(name = "primary") var primary: Boolean = false,
                     @Json(name = "type") var type: String? = null,
                     @Json(name = "colors") var colors: Any? = null,
                     @Json(name = "images") var images: Images? = null,
                     @Json(name = "score") var score: Double = 0.toDouble(),
                     @Json(name = "divisions") var divisions: Any? = null,
                     @Json(name = "name") var name: String? = null,
                     @Json(name = "num_upcoming_events") var numUpcomingEvents: Int = 0,
                     @Json(name = "image_license") var imageLicense: Any? = null,
                     @Json(name = "has_upcoming_events") var hasUpcomingEvents: Boolean = false,
                     @Json(name = "popularity") var popularity: Int = 0,
                     @Json(name = "id") var id: Int = 0,
                     @Json(name = "slug") var slug: String? = null,
                     @Json(name = "url") var url: String? = null,
                     @Json(name = "image_attribution") var imageAttribution: String? = null,
                     @Json(name = "statsEvent") var statsEvent: StatsEvent? = null,
                     @Json(name = "home_venue_id") var homeVenueId: Any? = null)
