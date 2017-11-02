package com.homeaway.domain.dto

import com.google.gson.annotations.SerializedName

data class Performer(@SerializedName("image") var image: String,
                     @SerializedName("short_name") var shortName: String,
                     @SerializedName("taxonomies") var taxonomies: List<Taxonomy>,
                     @SerializedName("primary") var primary: Boolean,
                     @SerializedName("type") var type: String,
                     @SerializedName("colors") var colors: Any,
                     @SerializedName("images") var images: Images,
                     @SerializedName("score") var score: Double,
                     @SerializedName("divisions") var divisions: Any,
                     @SerializedName("name") var name: String,
                     @SerializedName("num_upcoming_events") var numUpcomingEvents: Int,
                     @SerializedName("image_license") var imageLicense: Any,
                     @SerializedName("has_upcoming_events") var hasUpcomingEvents: Boolean,
                     @SerializedName("popularity") var popularity: Int,
                     @SerializedName("id") var id: Int,
                     @SerializedName("slug") var slug: String,
                     @SerializedName("url") var url: String,
                     @SerializedName("image_attribution") var imageAttribution: String,
                     @SerializedName("statsEvent") var statsEvent: StatsEvent,
                     @SerializedName("home_venue_id") var homeVenueId: Any)
