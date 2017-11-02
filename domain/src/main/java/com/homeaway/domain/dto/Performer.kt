package com.homeaway.domain.dto

import com.squareup.moshi.Json

data class Performer(@Json(name = "image") var image: String,
                     @Json(name = "short_name") var shortName: String,
                     @Json(name = "taxonomies") var taxonomies: List<Taxonomy>,
                     @Json(name = "primary") var primary: Boolean,
                     @Json(name = "type") var type: String,
                     @Json(name = "colors") var colors: Any,
                     @Json(name = "images") var images: Images,
                     @Json(name = "score") var score: Double,
                     @Json(name = "divisions") var divisions: Any,
                     @Json(name = "name") var name: String,
                     @Json(name = "num_upcoming_events") var numUpcomingEvents: Int,
                     @Json(name = "image_license") var imageLicense: Any,
                     @Json(name = "has_upcoming_events") var hasUpcomingEvents: Boolean,
                     @Json(name = "popularity") var popularity: Int,
                     @Json(name = "id") var id: Int,
                     @Json(name = "slug") var slug: String,
                     @Json(name = "url") var url: String,
                     @Json(name = "image_attribution") var imageAttribution: String,
                     @Json(name = "statsEvent") var statsEvent: StatsEvent,
                     @Json(name = "home_venue_id") var homeVenueId: Any)
